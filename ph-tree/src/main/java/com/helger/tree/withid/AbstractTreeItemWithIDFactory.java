/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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
package com.helger.tree.withid;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.OverrideOnDemand;

/**
 * Abstract tree item with ID factory implementation
 *
 * @author Philip Helger
 * @param <KEYTYPE>
 *        tree item key type
 * @param <DATATYPE>
 *        tree item value type
 * @param <ITEMTYPE>
 *        tree item implementation type
 */
@NotThreadSafe
public abstract class AbstractTreeItemWithIDFactory <KEYTYPE, DATATYPE, ITEMTYPE extends ITreeItemWithID <KEYTYPE, DATATYPE, ITEMTYPE>>
                                                    implements
                                                    ITreeItemWithIDFactory <KEYTYPE, DATATYPE, ITEMTYPE>
{
  @OverrideOnDemand
  public void onRemoveItem (@Nonnull final ITEMTYPE aItem)
  {
    // it doesn't matter to us
  }

  @OverrideOnDemand
  public void onAddItem (@Nonnull final ITEMTYPE aItem)
  {
    // it doesn't matter to us
  }
}
