/*
 * Copyright 2012 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.miraclethings.prettytime.impl;

import nl.miraclethings.prettytime.TimeUnit;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public abstract class ResourcesTimeUnit implements TimeUnit
{
   private long maxQuantity = 0;
   private long millisPerUnit = 1;

   /**
    * Return the name of the resource bundle from which this unit's format should be loaded.
    */
   abstract protected String getResourceKeyPrefix();

   protected String getResourceBundleName()
   {
      return "nl.miraclethings.prettytime.i18n.Resources";
   }

   @Override
   public long getMaxQuantity()
   {
      return maxQuantity;
   }

   public void setMaxQuantity(long maxQuantity)
   {
      this.maxQuantity = maxQuantity;
   }

   @Override
   public long getMillisPerUnit()
   {
      return millisPerUnit;
   }

   public void setMillisPerUnit(long millisPerUnit)
   {
      this.millisPerUnit = millisPerUnit;
   }

   @Override
   public boolean isPrecise()
   {
      return true;
   }

   @Override
   public String toString()
   {
      return getResourceKeyPrefix();
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + (int) (maxQuantity ^ (maxQuantity >>> 32));
      result = prime * result + (int) (millisPerUnit ^ (millisPerUnit >>> 32));
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      ResourcesTimeUnit other = (ResourcesTimeUnit) obj;
      if (maxQuantity != other.maxQuantity)
         return false;
      if (millisPerUnit != other.millisPerUnit)
         return false;
      return true;
   }
}
