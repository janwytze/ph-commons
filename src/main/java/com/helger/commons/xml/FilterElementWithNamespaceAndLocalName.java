/**
 * Copyright (C) 2014 Philip Helger (www.helger.com)
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
package com.helger.commons.xml;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import org.w3c.dom.Element;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotations.Nonempty;
import com.helger.commons.equals.EqualsUtils;
import com.helger.commons.filter.ISerializableFilter;
import com.helger.commons.hash.HashCodeGenerator;
import com.helger.commons.string.ToStringGenerator;

/**
 * An implementation of {@link ISerializableFilter} on {@link Element} objects
 * that will only return elements with a certain namespace URI and a certain
 * local name.
 * 
 * @author Philip Helger
 */
@NotThreadSafe
public final class FilterElementWithNamespaceAndLocalName implements ISerializableFilter <Element>
{
  private final String m_sNamespaceURI;
  private final String m_sLocalName;

  public FilterElementWithNamespaceAndLocalName (@Nullable final String sNamespaceURI,
                                                 @Nonnull @Nonempty final String sLocalName)
  {
    m_sNamespaceURI = sNamespaceURI;
    m_sLocalName = ValueEnforcer.notEmpty (sLocalName, "LocalName");
  }

  public boolean matchesFilter (@Nullable final Element aElement)
  {
    return aElement != null &&
           XMLHelper.hasNamespaceURI (aElement, m_sNamespaceURI) &&
           aElement.getLocalName ().equals (m_sLocalName);
  }

  @Override
  public boolean equals (final Object o)
  {
    if (o == this)
      return true;
    if (!(o instanceof FilterElementWithNamespaceAndLocalName))
      return false;
    final FilterElementWithNamespaceAndLocalName rhs = (FilterElementWithNamespaceAndLocalName) o;
    return EqualsUtils.equals (m_sNamespaceURI, rhs.m_sNamespaceURI) && m_sLocalName.equals (rhs.m_sLocalName);
  }

  @Override
  public int hashCode ()
  {
    return new HashCodeGenerator (this).append (m_sNamespaceURI).append (m_sLocalName).getHashCode ();
  }

  @Override
  public String toString ()
  {
    return new ToStringGenerator (this).append ("namespaceURI", m_sNamespaceURI)
                                       .append ("localName", m_sLocalName)
                                       .toString ();
  }
}
