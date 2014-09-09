/*
 * Odoo, Open Source Management Solution
 * Copyright (C) 2012-today Odoo SA (<http:www.odoo.com>)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http:www.gnu.org/licenses/>
 * 
 */
package com.odoo.orm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;

public class OValues {
	private HashMap<String, Object> _values = new HashMap<String, Object>();

	public OValues() {
		_values.clear();
		_values = new HashMap<String, Object>();
	}

	public void put(String key, Object value) {
		_values.put(key, value);
	}

	public Object get(String key) {
		return _values.get(key);
	}

	public long getLong(String key) {
		if (_values.get(key).toString().equals("false")) {
			return -1;
		}
		return Long.parseLong(_values.get(key).toString());
	}

	public Integer getInt(String key) {
		if (_values.get(key).toString().equals("false")) {
			return -1;
		}
		return Integer.parseInt(_values.get(key).toString());
	}

	public String getString(String key) {
		return _values.get(key).toString();
	}

	public Boolean getBoolean(String key) {
		return Boolean.parseBoolean(_values.get(key).toString());
	}

	public boolean contains(String key) {
		return _values.containsKey(key);
	}

	public List<String> keys() {
		List<String> list = new ArrayList<String>();
		list.addAll(_values.keySet());
		return list;
	}

	public void setAll(OValues values) {
		for (String key : values.keys())
			_values.put(key, values.get(key));
	}

	public int size() {
		return _values.size();
	}

	@Override
	public String toString() {
		return _values.toString();
	}

	public ContentValues toContentValues() {
		ContentValues values = new ContentValues();
		for (String key : _values.keySet()) {
			Object val = _values.get(key);
			values.put(key, val.toString());
		}
		return values;
	}
}
