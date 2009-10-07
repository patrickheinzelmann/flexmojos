/**
 * Flexmojos is a set of maven goals to allow maven users to compile, optimize and test Flex SWF, Flex SWC, Air SWF and Air SWC.
 * Copyright (C) 2008-2012  Marvin Froeder <marvin@flexmojos.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sonatype.flexmojos.generator.iface;

import java.util.Arrays;

import junit.framework.TestCase;

public class StringUtilTest
    extends TestCase
{

    public void testPrefixRemoval()
    {
        String a = "abcCba";
        assertEquals( "Cba", StringUtil.removePrefix( a ) );
        a = "abc3Cba";
        assertEquals( "Cba", StringUtil.removePrefix( a ) );
    }

    public void testSplit()
    {
        String a = "abcCba";
        assertEquals( Arrays.toString( new String[] { "abc", "cba" } ),
                      Arrays.toString( StringUtil.splitCamelCase( a ) ) );
    }

}
