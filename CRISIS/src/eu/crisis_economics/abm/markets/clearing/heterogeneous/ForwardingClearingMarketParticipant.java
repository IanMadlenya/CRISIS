/*
 * This file is part of CRISIS, an economics simulator.
 * 
 * Copyright (C) 2015 Ross Richardson
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
package eu.crisis_economics.abm.markets.clearing.heterogeneous;

import com.google.common.base.Preconditions;

import eu.crisis_economics.abm.Agent;

/**
  * A simple forwarding implementation of the {@link ClearingMarketParticipant}
  * interface. This implementation delegates calls to 
  * {@link #getMarketResponseFunction(ClearingMarketInformation) to a factory
  * for market responses.
  * 
  * @author phillips
  */
public final class ForwardingClearingMarketParticipant implements ClearingMarketParticipant {
   private final Agent
      owner;
   private final ClearingMarketsResponseFunctionFactory
      marketResponses;
   
   public ForwardingClearingMarketParticipant(
      final Agent owner,
      final ClearingMarketsResponseFunctionFactory marketResponses
      ) {
      Preconditions.checkNotNull(owner, marketResponses);
      this.owner = owner;
      this.marketResponses = marketResponses;
   }
   
   @Override
   public final MarketResponseFunction getMarketResponseFunction(
      final ClearingMarketInformation market) {
      return marketResponses.create(owner, market);
   }
   
   @Override
   public String getUniqueName() {
      return owner.getUniqueName();
   }
}
