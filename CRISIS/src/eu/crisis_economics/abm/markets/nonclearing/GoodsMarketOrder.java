/*
 * This file is part of CRISIS, an economics simulator.
 * 
 * Copyright (C) 2015 Ross Richardson
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
package eu.crisis_economics.abm.markets.nonclearing;


import eu.crisis_economics.abm.markets.GoodsBuyer;
import eu.crisis_economics.abm.markets.GoodsSeller;
import eu.crisis_economics.abm.markets.Party;
import eu.crisis_economics.abm.markets.nonclearing.DefaultFilters.Filter;
import eu.crisis_economics.abm.contracts.GoodHolder;

public class GoodsMarketOrder extends Order {
    
	public GoodsMarketOrder(Party party, Instrument instrument, double size,
			double price, Filter filter) throws OrderException {
		super(party, instrument, size, price);
		
		
		
	}

	@Override
	protected void disallocatePartyAsset() {
		if (this.getSide()==Order.Side.BUY) {
            ((GoodsBuyer)this.getParty()).disallocateCash(getOpenSize()*this.getPrice());
		} else {
			GoodsInstrument inst = (GoodsInstrument) this.getInstrument();
			((GoodsSeller)this.getParty()).getGoodsRepository().changeAllocatedQuantityBy(
			   inst.getGoodsType(),-getOpenSize());
		}
	}
		
	

	@Override
	public boolean isRegisteredSeller(Party party) {
		if ( null == party ) {
			throw new IllegalArgumentException( "party == null" );
		}
		
		if (party instanceof GoodHolder) return true; 
		else return false;
	}

	@Override
	public boolean isRegisteredBuyer(Party party) {
		
		if ( null == party ) {
			throw new IllegalArgumentException( "party == null" );
		}
		
		if (party instanceof GoodHolder) return true; 
		else return false;
	}
}
