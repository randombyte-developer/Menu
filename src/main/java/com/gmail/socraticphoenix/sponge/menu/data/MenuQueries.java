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
package com.gmail.socraticphoenix.sponge.menu.data;

import org.spongepowered.api.data.DataQuery;

public interface MenuQueries {

    DataQuery VARIABLES = DataQuery.of('.', "menuapi.context.variables");

    DataQuery SENDABLE_MENU = DataQuery.of('.', "menuapi.sendable.menu");
    DataQuery SENDABLE_PLUGIN = DataQuery.of('.', "menuapi.sendable.plugin");
    DataQuery SENDABLE_SPECIFIC_FORMATTERS = DataQuery.of('.', "menuapi.sendable.specific");
    DataQuery SENDABLE_FORMATTERS = DataQuery.of('.', "menuapi.sendable.formatters");

    DataQuery BUTTON_TYPE = DataQuery.of('.', "menuapi.button.type");
    DataQuery BUTTON_ICON = DataQuery.of('.', "menuapi.button.icon");
    DataQuery BUTTON_TITLE = DataQuery.of('.', "menuapi.button.title");
    DataQuery BUTTON_ID = DataQuery.of('.', "menuapi.button.id");

    DataQuery MENU_TYPE = DataQuery.of('.', "menuapi.menu.type");
    DataQuery MENU_PAGES = DataQuery.of('.', "menuapi.menu.pages");
    DataQuery MENU_OWNER = DataQuery.of('.', "menuapi.menu.owner");

    DataQuery INPUT_TYPE = DataQuery.of('.', "menuapi.input.type");

    DataQuery CONTEXT_PAGE = DataQuery.of('.', "menuapi.context.page");
    DataQuery CONTEXT_INPUT = DataQuery.of('.', "menuapi.context.input");
    DataQuery CONTEXT_INPUT_TYPE = DataQuery.of('.', "menuapi.context.inputtype");
    DataQuery CONTEXT_MENU_TYPE = DataQuery.of('.', "menuapi.context.menutype");
    DataQuery CONTEXT_SPECIFIC_FORMATTERS = DataQuery.of('.', "menuapi.context.specific");
    DataQuery CONTEXT_FORMATTERS = DataQuery.of('.', "menuapi.context.formatters");
    DataQuery CONTEXT_VARIABLES = DataQuery.of('.', "menuapi.context.variables");

    DataQuery FORMATTER_OWNER = DataQuery.of('.', "menuapi.formatter.owner");
    DataQuery FORMATTER_TARGET = DataQuery.of('.', "menuapi.formatter.target");
    DataQuery FORMATTER_PAGE = DataQuery.of('.', "menuapi.formatter.page");

    DataQuery PAGE_TITLE = DataQuery.of('.', "menuapi.page.title");
    DataQuery PAGE_ID = DataQuery.of('.', "menuapi.page.id");
    DataQuery PAGE_INPUT = DataQuery.of('.', "menuapi.page.input");
    DataQuery PAGE_BUTTONS = DataQuery.of('.', "menuapi.page.buttons");
    DataQuery PAGE_HEIGHT = DataQuery.of('.', "menuapi.page.height");
    DataQuery PAGE_LENGTH = DataQuery.of('.', "menuapi.page.length");

    DataQuery SERIALIZABLE_PAIR_LEFT = DataQuery.of('.', "menuapi.pair.left");
    DataQuery SERIALIZABLE_PAIR_RIGHT = DataQuery.of('.', "menuapi.pair.right");
    DataQuery SERIALIZABLE_PAIR_LEFT_TARGET = DataQuery.of('.', "menuapi.pair.left_target");
    DataQuery SERIALIZABLE_PAIR_RIGHT_TARGET = DataQuery.of('.', "menuapi.pair.right_target");


    DataQuery ORDERED_GRID_VERTICAL = DataQuery.of('.', "menuapi.formatter.orderedgrid.vertical");
    DataQuery STRICT_GRID_LOCATIONS = DataQuery.of('.', "menuapi.formatter.strictgrid.locations");



}
