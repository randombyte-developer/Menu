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
package com.gmail.socraticphoenix.sponge.menu;

/**
 * Contains all the default {@link ButtonType ButtonTypes}.
 */
public interface ButtonTypes {

    /**
     * A {@link Button} which has a title, and no icon.
     */
    ButtonType TEXT = new ButtonType("menuapi:text", "Text Button");
    /**
     * A {@link Button} which has a title and an icon.
     */
    ButtonType ITEM = new ButtonType("menuapi:item", "Item Button");
    /**
     * A {@link Button} whose type is unknown. This type can be used by plugins adding their own {@link Button}
     * implementation, though it is suggested that such {@link Button Buttons} have their own custom type.
     */
    ButtonType UNKNOWN = new ButtonType("menuapi:unknown", "Unknown Button");

}
