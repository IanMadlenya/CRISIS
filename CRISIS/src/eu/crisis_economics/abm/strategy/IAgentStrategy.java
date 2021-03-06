/*
 * This file is part of CRISIS, an economics simulator.
 * 
 * Copyright (C) 2015 Olaf Bochmann
 * Copyright (C) 2015 John Kieran Phillips
 * Copyright (C) 2015 Daniel Tang
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
package eu.crisis_economics.abm.strategy;

import eu.crisis_economics.abm.markets.nonclearing.Order;

// DOCME
public interface IAgentStrategy {
	
	/**
	 * Subclasses should implement the bank's deposit-market strategy by overriding this function. This method is called once
	 * in each turn to allow the bank to make its move. The default implementation does nothing.
	 */
	public abstract void considerDepositMarkets(StrategyAgent agent);
	
	/**
	 * Subclasses should implement the bank's commercial loan strategy here. This method is called once in each turn to allow
	 * the bank to make its move. The default implementation does nothing.
	 */
	public abstract void considerCommercialLoanMarkets(StrategyAgent agent);
	
    public abstract void considerBondMarkets(StrategyAgent agent);
	
	/**
	 * Subclasses should implement the bank's stock-market strategy here. This method is called once in each turn to allow
	 * the bank to make its move. The default implementation does nothing.
	 */
	public abstract void considerStockMarkets(StrategyAgent agent);
	
	/**
	 * Subclasses should implement the bank's interbank-loan-market strategy here. This method is called once in each turn to
	 * allow the bank to make its move. The default implementation does nothing.
	 */
	public abstract void considerInterbankMarkets(StrategyAgent agent);
	
	/**
	 * Returns the current deposit rate. This is a read-only Java Bean Property which can be used in an inspector.
	 */
	public abstract double getDepositRate(StrategyAgent agent); //TODO consider using market value
	
	/**
	 * Returns the current lending rate. This is a read-only Java Bean Property which can be used in an inspector.
	 */
	public abstract double getLendingRate(StrategyAgent agent); //TODO consider using market value
	
	/**
	 * Returns the current interbank lending rate. This is a read-only Java Bean Property which can be used in an inspector.
	 * 
	 * @return InterLendingRate
	 */
	public abstract double getInterLendingRate(StrategyAgent agent); //TODO consider using market value
	
	// TODO Unused?
	public abstract double getLoanSize(StrategyAgent agent);
	
	public abstract void newOrder(Order o);
	
	/**
	 * Return the order size placed on the commercial loan market
	 */
	
	public abstract double getCommercialLoanOrderSize();
}
