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
package net.sf.guavaeclipse.preferences;

import static net.sf.guavaeclipse.preferences.EqualsEqualityType.INSTANCEOF;
import static net.sf.guavaeclipse.preferences.FieldsGetterType.FIELDS;
import static net.sf.guavaeclipse.preferences.HashCodeStrategyType.SMART_HASH_CODE;
import static net.sf.guavaeclipse.preferences.MethodGenerationStratergy.SMART_OPTION;
import static net.sf.guavaeclipse.preferences.UserPreferencePage.FIELDS_GETTER_PREFERENCE;
import static net.sf.guavaeclipse.preferences.UserPreferencePage.HASH_CODE_STRATEGY_PREFERENCE;
import static net.sf.guavaeclipse.preferences.UserPreferencePage.HIDE_COMPARE_TO_PREFERENCE;
import static net.sf.guavaeclipse.preferences.UserPreferencePage.INSTANCEOF_CLASSEQUALS_PREFERENCE;
import static net.sf.guavaeclipse.preferences.UserPreferencePage.SUPERCALL_STRATEGY_PREFERENCE;
import net.sf.guavaeclipse.Activator;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

  @Override
  public void initializeDefaultPreferences() {
    IPreferenceStore store = Activator.getDefault().getPreferenceStore();
    store.setDefault(SUPERCALL_STRATEGY_PREFERENCE, SMART_OPTION.name());
    store.setDefault(INSTANCEOF_CLASSEQUALS_PREFERENCE, INSTANCEOF.name());
    store.setDefault(FIELDS_GETTER_PREFERENCE, FIELDS.name());
    store.setDefault(HASH_CODE_STRATEGY_PREFERENCE, SMART_HASH_CODE.name());
    store.setDefault(HIDE_COMPARE_TO_PREFERENCE, Boolean.FALSE.toString());
  }
}
