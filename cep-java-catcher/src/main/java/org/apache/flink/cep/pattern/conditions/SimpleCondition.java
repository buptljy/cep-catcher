/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.cep.pattern.conditions;

import org.apache.flink.cep.nfa.NFA;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.cep.event.EventWrapper;

/**
 *  A user-defined condition that decides if an element should be accepted in the org.apache.flink.scala.cep.pattern or not.
 * Accepting an element also signals a state transition for the corresponding {@link NFA}.
 *
 * <p>Contrary to the {@link IterativeCondition}, org.apache.flink.scala.cep.conditions that extend this class do not have access to the
 * previously accepted elements in the org.apache.flink.scala.cep.pattern. Conditions that extend this class are simple {@code filter(...)}
 * functions that decide based on the properties of the element at hand.
 */
public abstract class SimpleCondition extends IterativeCondition implements FilterFunction<EventWrapper> {

	private static final long serialVersionUID = 4942618239408140245L;

	@Override
	public boolean filter(EventWrapper value, Context ctx) throws Exception {
		return filter(value);
	}
}
