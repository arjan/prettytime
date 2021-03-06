package nl.miraclethings.prettytime.i18n;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.Test;
import nl.miraclethings.prettytime.PrettyTime;
import nl.miraclethings.prettytime.impl.TimeFormatProvider;

public class TimeFormatProviderTest
{
   @Test
   public void test()
   {
      ResourceBundle bundle = ResourceBundle.getBundle("nl.miraclethings.prettytime.i18n.Resources", new Locale("xx"));
      Assert.assertTrue(bundle instanceof TimeFormatProvider);
   }

   @Test
   public void testFormatFromDirectFormatOverride() throws Exception
   {
      PrettyTime prettyTime = new PrettyTime(new Locale("xx"));
      String result = prettyTime.format(new Date(System.currentTimeMillis() + 1000 * 60 * 6));
      Assert.assertEquals("6 minuti from now", result);
   }

}
