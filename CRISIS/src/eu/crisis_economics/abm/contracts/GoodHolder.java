/*
 * This file is part of CRISIS, an economics simulator.
 * 
 * Copyright (C) 2015 John Kieran Phillips
 * Copyright (C) 2015 Jakob Grazzini
 * Copyright (C) 2015 Alessandro Gobbi
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
package eu.crisis_economics.abm.contracts;

import eu.crisis_economics.abm.HasAssets;
import eu.crisis_economics.abm.inventory.goods.GoodsRepository;
import eu.crisis_economics.abm.markets.GoodsMarketParty;

public interface GoodHolder extends GoodsMarketParty, HasAssets {
    GoodsRepository getGoodsRepository();
}
