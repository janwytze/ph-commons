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
package com.helger.commons.supplementary.test.java;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.Semaphore;

import org.junit.Test;

public class JavaSemaphoreAPITest
{
  @Test
  public void testSimple () throws InterruptedException
  {
    final int n = 5;
    final Semaphore a = new Semaphore (n);
    assertEquals (n, a.availablePermits ());

    a.acquire ();
    assertEquals (n - 1, a.availablePermits ());
    a.release ();
    assertEquals (n, a.availablePermits ());

    a.acquire (3);
    assertEquals (n - 3, a.availablePermits ());
    a.release (3);
    assertEquals (n, a.availablePermits ());
  }
}
