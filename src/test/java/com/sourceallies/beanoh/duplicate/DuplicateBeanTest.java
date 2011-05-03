/*
Copyright (c) 2011  Source Allies

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation version 3.0.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, please visit 
http://www.gnu.org/licenses/lgpl-3.0.txt.
 */

package com.sourceallies.beanoh.duplicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.sourceallies.beanoh.BeanohTestCase;
import com.sourceallies.beanoh.exception.DuplicateBeanDefinitionException;

public class DuplicateBeanTest extends BeanohTestCase {

	@Test
	public void testDups() {
		try {
			assertUniqueBeanContextLoading();
			fail();
		} catch (DuplicateBeanDefinitionException e) {
			assertEquals(
					"Bean 'person' was defined 2 times:\n\n"
							+ "class path resource [com/sourceallies/beanoh/duplicate/FirstDuplicate-context.xml]\n"
							+ "class path resource [com/sourceallies/beanoh/duplicate/SecondDuplicate-context.xml]",
					e.getMessage());
		}
	}
}
