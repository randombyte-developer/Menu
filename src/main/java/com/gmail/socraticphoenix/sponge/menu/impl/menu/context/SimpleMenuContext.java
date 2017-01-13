/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 socraticphoenix@gmail.com
 * Copyright (c) 2016 contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.gmail.socraticphoenix.sponge.menu.impl.menu.context;

import com.gmail.socraticphoenix.sponge.menu.EndMenuReason;
import com.gmail.socraticphoenix.sponge.menu.Formatter;
import com.gmail.socraticphoenix.sponge.menu.InputContext;
import com.gmail.socraticphoenix.sponge.menu.Menu;
import com.gmail.socraticphoenix.sponge.menu.MenuContext;
import com.gmail.socraticphoenix.sponge.menu.MenuRegistry;
import com.gmail.socraticphoenix.sponge.menu.MenuVariables;
import com.gmail.socraticphoenix.sponge.menu.Page;
import com.gmail.socraticphoenix.sponge.menu.PageTarget;
import com.gmail.socraticphoenix.sponge.menu.data.MenuQueries;
import com.gmail.socraticphoenix.sponge.menu.data.attached.player.MenuData;
import com.gmail.socraticphoenix.sponge.menu.data.pair.SerializablePair;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleMenuContext implements MenuContext {
    private int page;
    private InputContext context;
    private Menu.Type type;
    private PluginContainer owner;
    private Set<Formatter> formatters;
    private Map<String, Formatter> specificFormatters;
    private MenuVariables variables;

    public SimpleMenuContext(Menu.Type type, int page, InputContext context, PluginContainer owner, Map<String, Formatter> specificFormatters, Set<Formatter> formatters, MenuVariables variables) {
        this.page = page;
        this.context = context;
        this.type = type;
        this.owner = owner;
        this.formatters = Collections.unmodifiableSet(formatters);
        this.specificFormatters = Collections.unmodifiableMap(specificFormatters);
        this.variables = variables;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int page() {
        return this.page;
    }

    @Override
    public InputContext input() {
        return this.context;
    }

    @Override
    public Menu.Type type() {
        return this.type;
    }

    @Override
    public PluginContainer owner() {
        return this.owner;
    }

    @Override
    public Set<Formatter> formatters() {
        return this.formatters;
    }

    @Override
    public MenuVariables variables() {
        return this.variables;
    }

    @Override
    public void refresh(Player player, Menu menu) {
        if (this.page < menu.pages().size() && this.page >= 0) {
            Page page = menu.pages().get(this.page);
            PageTarget target = page.produceTarget();
            Formatter usableFormatter = null;
            for (Formatter formatter : this.formatters) {
                if (formatter.page().isInstance(page) && formatter.target().isInstance(target)) {
                    usableFormatter = formatter;
                    break;
                }
            }

            if (usableFormatter != null) {
                usableFormatter.format(page, target, this.owner());
                MenuRegistry.lookForAppropriate(target.getClass(), page.getClass()).display(player, target, page, this.owner);
            } else {
                player.sendMessage(Text.of(TextColors.RED, "[MenuAPI] Error: no formatter in context for page \"" + page.getClass() + "\" and target \"" + target.getClass() + "\""));
                this.terminate(EndMenuReason.ERROR, player, menu);
            }
        } else {
            player.sendMessage(Text.of(TextColors.RED, "[MenuAPI] Error: " + this.page + " is out of bounds"));
            this.terminate(EndMenuReason.ERROR, player, menu);
        }
    }

    @Override
    public void terminate(EndMenuReason reason, Player player, Menu menu) {
        player.remove(MenuData.class);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        List<Formatter> formatters = new ArrayList<>();
        formatters.addAll(this.formatters);
        List<SerializablePair<String, Formatter>> specificFormatters = new ArrayList<>();
        for (Map.Entry<String, Formatter> entry : this.specificFormatters.entrySet()) {
            specificFormatters.add(new SerializablePair<>(entry.getKey(), entry.getValue(), String.class, Formatter.class));
        }

        return new MemoryDataContainer().set(Queries.CONTENT_VERSION, this.getContentVersion())
                .set(MenuQueries.CONTEXT_MENU_TYPE, this.type)
                .set(MenuQueries.CONTEXT_PAGE, this.page)
                .set(MenuQueries.MENU_OWNER, this.owner.getId())
                .set(MenuQueries.CONTEXT_INPUT, this.context)
                .set(MenuQueries.CONTEXT_FORMATTERS, formatters)
                .set(MenuQueries.CONTEXT_SPECIFIC_FORMATTERS, specificFormatters)
                .set(MenuQueries.CONTEXT_VARIABLES, this.variables);
    }

}
