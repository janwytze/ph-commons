/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
package com.helger.commons.messagedigest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.security.MessageDigest;
import java.util.Locale;

import org.junit.Test;

import com.helger.commons.charset.CCharset;
import com.helger.commons.charset.CharsetManager;
import com.helger.commons.string.StringHelper;

/**
 * Test class for class {@link EMessageDigestAlgorithm}.
 *
 * @author Philip Helger
 */
public final class EMessageDigestAlgorithmTest
{
  @Test
  public void testAll ()
  {
    for (final EMessageDigestAlgorithm eAlgo : EMessageDigestAlgorithm.values ())
    {
      assertTrue (StringHelper.hasText (eAlgo.getAlgorithm ()));
      assertNotNull (eAlgo.createMessageDigest ());
      assertSame (eAlgo, EMessageDigestAlgorithm.getFromStringIgnoreCase (eAlgo.getAlgorithm ()));
      assertSame (eAlgo,
                  EMessageDigestAlgorithm.getFromStringIgnoreCase (eAlgo.getAlgorithm ().toLowerCase (Locale.US)));
      assertSame (eAlgo,
                  EMessageDigestAlgorithm.getFromStringIgnoreCase (eAlgo.getAlgorithm ().toUpperCase (Locale.US)));
      assertSame (eAlgo, EMessageDigestAlgorithm.valueOf (eAlgo.name ()));
    }
    assertNull (EMessageDigestAlgorithm.getFromStringIgnoreCase (null));
    assertNull (EMessageDigestAlgorithm.getFromStringIgnoreCase ("bla"));
  }

  @Test
  public void testConsistency ()
  {
    // For all algorithms
    for (final EMessageDigestAlgorithm eAlgo : EMessageDigestAlgorithm.values ())
    {
      // Create 2 MDGens
      final MessageDigest aMD1 = eAlgo.createMessageDigest ();
      final MessageDigest aMD2 = eAlgo.createMessageDigest ();
      for (int i = 0; i < 255; ++i)
      {
        final byte [] aBytes = CharsetManager.getAsBytes ("abc" + i + "def", CCharset.CHARSET_ISO_8859_1_OBJ);
        aMD1.update ((byte) i);
        aMD1.update (aBytes);
        aMD2.update ((byte) i);
        aMD2.update (aBytes);
      }

      // Results must be equal
      assertArrayEquals (aMD1.digest (), aMD2.digest ());
    }
  }
}
