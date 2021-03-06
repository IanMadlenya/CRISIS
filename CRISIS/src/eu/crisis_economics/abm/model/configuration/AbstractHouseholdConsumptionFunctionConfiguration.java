/*
 * This file is part of CRISIS, an economics simulator.
 * 
 * Copyright (C) 2015 John Kieran Phillips
 *
 * CRISIS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CRISIS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CRISIS.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.crisis_economics.abm.model.configuration;

import com.google.inject.Key;
import com.google.inject.name.Names;

import eu.crisis_economics.abm.household.plugins.HouseholdConsumptionFunction;

/**
  * An abstract configuration base class for {@link Household} consumption 
  * functions.
  * 
  * @author phillips
  */
public abstract class AbstractHouseholdConsumptionFunctionConfiguration
   extends AbstractPrivateConfiguration {
   
   private static final long serialVersionUID = 3600781993543883918L;
   
   /**
     * Create a {@link AbstractHouseholdConsumptionFunctionConfiguration} object.<br><br>
     * Implementations of this class should provide the following bindings:
     * 
     * <ul>
     *   <li> An implementation of {@link HouseholdConsumptionFunction}{@code .class}.
     * </ul>
     */
   protected AbstractHouseholdConsumptionFunctionConfiguration() { }
   
   @Override
   protected void setRequiredBindings() {
      requireBinding(
         Key.get(HouseholdConsumptionFunction.class, Names.named(getScopeString())));
   }
}
