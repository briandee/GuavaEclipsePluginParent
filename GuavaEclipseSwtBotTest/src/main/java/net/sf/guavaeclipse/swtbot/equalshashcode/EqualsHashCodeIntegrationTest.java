/*
 * Copyright 2014
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package net.sf.guavaeclipse.swtbot.equalshashcode;

import static net.sf.guavaeclipse.swtbot.MenuSelection.EQUALS_HASHCODE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import net.sf.guavaeclipse.swtbot.AbstractSwtBotIntegrationTest;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(SWTBotJunit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EqualsHashCodeIntegrationTest extends AbstractSwtBotIntegrationTest {

  @BeforeClass
  public static void changePreferences() throws Exception {
    selectSmartSuper();
  }

  @Test
  public void createEqualsHashCode() throws Exception {

    SWTBotEclipseEditor cutEditor = executeTestForSampleSimple(EQUALS_HASHCODE);

    String editorText = cutEditor.getText();
    String expectedText = readFile("equalsHashCodeResults/Expected_EqualsHashCode.txt");
    assertThat(editorText, is(expectedText));
  }

  @Test
  public void createEqualsHashCodeForExtendedClass() throws Exception {

    SWTBotEclipseEditor cutEditor = executeTestForExtendedClass(EQUALS_HASHCODE);

    String editorText = cutEditor.getText();
    String expectedText =
        readFile("equalsHashCodeResults/Expected_EqualsHashCodeForExtendedClass.txt");
    assertThat(editorText, is(expectedText));
  }

  @Test
  public void createEqualsHashCodeForInterfaceClass() throws Exception {

    SWTBotEclipseEditor cutEditor = executeTestForInterface(EQUALS_HASHCODE);

    String editorText = cutEditor.getText();
    String expectedText =
        readFile("equalsHashCodeResults/Expected_EqualsHashCodeForInterfaceClass.txt");
    assertThat(editorText, is(expectedText));
  }


  @Test
  public void createEqualsHashCodeForInterfaceClassAndExtendedClass() throws Exception {

    SWTBotEclipseEditor cutEditor = executeTestForSuperClassAndInterface(EQUALS_HASHCODE);

    String editorText = cutEditor.getText();
    String expectedText =
        readFile("equalsHashCodeResults/Expected_EqualsHashCodeForInterfaceAndExtendedClass.txt");
    assertThat(editorText, is(expectedText));
  }

  @Test
  public void replaceEqualsAndHashCode() throws Exception {

    SWTBotMenu menu = bot.menu("Navigate").click();
    menu.menu("Open Type...").click();
    bot.text().setText("SampleSimple");
    bot.button("OK").click();
    sleep();
    SWTBotEclipseEditor cutEditor = setClassContent("SampleSimple_Overwrite_EqualsHashCode", 9);
    SWTBotMenu contextMenu = cutEditor.contextMenu("Google Guava Helper");
    contextMenu.setFocus();
    contextMenu.menu("Generate hashCode() and equals()").click();

    assertNotNull(bot.label("hashCode() and equals() already present. Replace both?"));
    bot.button("Yes").click();
    bot.button("Select All").click();
    bot.button("OK").click();
    sleep();
    cutEditor.save();

    String editorText = cutEditor.getText();
    String expectedText = readFile("equalsHashCodeResults/Expected_EqualsHashCode_Overwrite.txt");
    assertThat(editorText, is(expectedText));
  }

  @Test
  public void replaceEqualsAndHashCodeAgain() throws Exception {

    SWTBotEclipseEditor cutEditor = setClassContent("SampleSimple_Overwrite_EqualsHashCode", 9);
    SWTBotMenu contextMenu = cutEditor.contextMenu("Google Guava Helper");
    contextMenu.setFocus();
    contextMenu.menu("Generate hashCode() and equals()").click();

    assertNotNull(bot.label("hashCode() and equals() already present. Replace both?"));
    bot.button("No").click();
    assertNotNull(bot.label("equals() already present. Replace it?"));
    bot.button("Yes").click();
    assertNotNull(bot.label("hashCode() already present. Replace it?"));
    bot.button("Yes").click();
    bot.button("Select All").click();
    bot.button("OK").click();
    sleep();
    cutEditor.save();

    String editorText = cutEditor.getText();
    String expectedText = readFile("equalsHashCodeResults/Expected_EqualsHashCode_Overwrite.txt");
    assertThat(editorText, is(expectedText));
  }

  @Test
  public void replaceOnlyEquals() throws Exception {

    SWTBotEclipseEditor cutEditor = setClassContent("SampleSimple_Overwrite_EqualsHashCode", 9);
    SWTBotMenu contextMenu = cutEditor.contextMenu("Google Guava Helper");
    contextMenu.setFocus();
    contextMenu.menu("Generate hashCode() and equals()").click();

    assertNotNull(bot.label("hashCode() and equals() already present. Replace both?"));
    bot.button("No").click();
    assertNotNull(bot.label("equals() already present. Replace it?"));
    bot.button("Yes").click();
    assertNotNull(bot.label("hashCode() already present. Replace it?"));
    bot.button("No").click();
    bot.button("Select All").click();
    bot.button("OK").click();
    sleep();
    cutEditor.save();

    String editorText = cutEditor.getText();
    String expectedText =
        readFile("equalsHashCodeResults/Expected_EqualsHashCode_OverwriteOnlyEquals.txt");
    assertThat(editorText, is(expectedText));
  }

  @Test
  public void replaceOnlyHashCode() throws Exception {

    SWTBotEclipseEditor cutEditor = setClassContent("SampleSimple_Overwrite_EqualsHashCode", 9);
    SWTBotMenu contextMenu = cutEditor.contextMenu("Google Guava Helper");
    contextMenu.setFocus();
    contextMenu.menu("Generate hashCode() and equals()").click();

    assertNotNull(bot.label("hashCode() and equals() already present. Replace both?"));
    bot.button("No").click();
    assertNotNull(bot.label("equals() already present. Replace it?"));
    bot.button("No").click();
    assertNotNull(bot.label("hashCode() already present. Replace it?"));
    bot.button("Yes").click();
    bot.button("Select All").click();
    bot.button("OK").click();
    sleep();
    cutEditor.save();

    String editorText = cutEditor.getText();
    String expectedText =
        readFile("equalsHashCodeResults/Expected_EqualsHashCode_OverwriteOnlyHashCode.txt");
    assertThat(editorText, is(expectedText));
  }

}
