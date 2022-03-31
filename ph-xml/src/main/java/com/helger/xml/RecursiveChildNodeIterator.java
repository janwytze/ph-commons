/*
 * Copyright (C) 2014-2022 Philip Helger (www.helger.com)
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
package com.helger.xml;

import java.util.Iterator;

import javax.annotation.Nonnull;

import org.w3c.dom.Node;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.collection.iterate.IIterableIterator;
import com.helger.commons.string.ToStringGenerator;

/**
 * Iterate all children of the start node, but NOT the start node itself.
 *
 * @author Philip Helger
 */
public class RecursiveChildNodeIterator implements IIterableIterator <Node>
{
  private final Iterator <Node> m_aIter;

  public RecursiveChildNodeIterator (@Nonnull final Node aParent)
  {
    ValueEnforcer.notNull (aParent, "Parent");

    final ICommonsList <Node> aNodes = new CommonsArrayList <> ();
    XMLHelper.recursiveIterate (aParent, aNodes::add);
    m_aIter = aNodes.iterator ();
  }

  public boolean hasNext ()
  {
    return m_aIter.hasNext ();
  }

  public Node next ()
  {
    return m_aIter.next ();
  }

  @Override
  public String toString ()
  {
    return new ToStringGenerator (this).append ("iter", m_aIter).getToString ();
  }
}
