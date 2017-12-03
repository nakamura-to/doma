/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.message;

import java.util.Locale;

import junit.framework.TestCase;

/**
 * @author taedium
 * 
 */
public class MessageTest extends TestCase {

    private Locale locale;

    @Override
    protected void setUp() throws Exception {
        locale = Locale.getDefault();
        Locale.setDefault(Locale.US);
    }

    @Override
    protected void tearDown() throws Exception {
        Locale.setDefault(locale);
    }

    public void testDOMA0001() throws Exception {
        String message = Message.DOMA0001.getMessage("aaa", "bbb");
        assertNotNull(message);
        System.out.println(message);
    }

    public void testDOMA0001_ja() throws Exception {
        String message = Message.DOMA0001.getMessage("aaa", "bbb");
        Locale.setDefault(Locale.JAPAN);
        String message_jp = Message.DOMA0001.getMessage("aaa", "bbb");
        System.out.println(message);
        System.out.println(message_jp);
        assertFalse(message.equals(message_jp));
    }

    public void testDOMA4019() throws Exception {
        String message = Message.DOMA4019.getMessage("aaa", "bbb");
        assertNotNull(message);
        System.out.println(message);
    }

    public void testDOMA4021() throws Exception {
        String message = Message.DOMA4021.getMessage("aaa", "bbb");
        assertNotNull(message);
        System.out.println(message);
    }
}
