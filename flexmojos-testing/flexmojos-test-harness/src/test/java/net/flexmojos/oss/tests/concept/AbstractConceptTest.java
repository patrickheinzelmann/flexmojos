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
package net.flexmojos.oss.tests.concept;

import java.io.File;

import net.flexmojos.oss.test.FMVerifier;
import net.flexmojos.oss.tests.AbstractFlexMojosTests;
import org.testng.annotations.DataProvider;

public abstract class AbstractConceptTest
    extends AbstractFlexMojosTests
{

    public FMVerifier standardConceptTesterWithForcedSdk( String conceptName, String sdkVersion )
            throws Exception
    {
        File testDir = getProjectWithForcedSdk( "/concept/" + conceptName, sdkVersion );
        return test( testDir, "install", "-DfdkVersion=" + sdkVersion +
                " -DfdkGroupId=" + getFlexGroupId(sdkVersion));
    }

    public FMVerifier standardConceptTester( String conceptName, String... args )
        throws Exception
    {
        File testDir = getProject( "/concept/" + conceptName );
        return test( testDir, "install", args );
    }

    @DataProvider( name = "flex3" )
    public Object[][] flex3()
    {
        return new Object[][] { { "3.0.0.477A" }, { "3.0.1.1732A" }, { "3.1.0.2710A" }, { "3.2.0.3958A" },
                { "3.3.0.4852A" }, { "3.4.0.9271A" }, { "3.4.1.10084A" }, { "3.5.0.12683B" }, { "3.6.0.16995A" } };
    }

    /**
 	 * Older Flex3 Versions don't come with AIR capabilities, so if we
 	 * run the AIR tests against them, we will be getting errors.
 	 *
 	 * @return List of Flex3 versions that support building of AIR applications.
 	*/
 	@DataProvider( name = "flex3Air" )
 	public Object[][] flex3Air()
 	{
 	    return new Object[][] { { "3.5.0.12683B" }, { "3.6.0.16995A" } };
 	}

    @DataProvider( name = "flex4" )
    public Object[][] flex4()
    {
        return new Object[][] { { "4.0.0.14159A" }, { "4.1.0.16076A" }, { "4.5.0.20967A" }, { "4.5.1.21328A" },
                { "4.6.0.23201" } };
    }

}
