/**
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.commons.functional;

import java.io.Serializable;
import java.util.function.Supplier;

/**
 * Represents a supplier of results that is serializable.
 * <p>
 * There is no requirement that a new or distinct result be returned each time
 * the supplier is invoked.
 * <p>
 * This is a functional interface whose functional method is {@link #get()}.
 *
 * @param <T>
 *        the type of results supplied by this supplier
 * @since 8.6.0
 */
@FunctionalInterface
public interface ISupplier <T> extends Supplier <T>, Serializable
{
  /* empty */
}
