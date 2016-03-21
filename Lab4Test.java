import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;

/**
 * The test class Lab4Test.
 *
 * @author  Scot Morse
 */
public class Lab4Test extends junit.framework.TestCase
{
	
    /**
     * Default constructor for test class Lab4Test
     */
    public Lab4Test()
    {
    }
    
    /* ------------------------------------------------------ */
    
    /* ++++++++++ Test the HybridTST only ++++++++++ */
    
	public void test0()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        assertTrue( t.isEmpty() );
	}
	
	public void test1()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        t.put("A",new Integer(0));
        assertFalse( t.isEmpty() );
	}
    
	public void test2()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        assertEquals( 0, t.size() );
	}
	
	public void test3()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        t.put("A",new Integer(0));
        assertEquals( 1, t.size() );
        assertFalse( t.isEmpty() );
	}
    
	public void test4()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","A","A","A","A"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals( 1, t.size() );
        assertFalse( t.isEmpty() );
	}
    
	public void test5()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","B","C","D","E"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals( 5, t.size() );
        assertFalse( t.isEmpty() );
	}
    
	public void test6()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals( 5, t.size() );
        assertFalse( t.isEmpty() );
	}
    
	public void test7()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"zef", "kra","ref","tem","are"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals( 5, t.size() );
        assertFalse( t.isEmpty() );
	}
    
	public void test8()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String s = "A";
        Integer i = new Integer(0);
        t.put(s,i);
        assertEquals( i, t.get(s) );
        assertSame( i, t.get(s) );
	}
    
	public void test9()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        t.put("A",new Integer(0));
        t.put("AB",new Integer(1));
        assertEquals( new Integer(0), t.get("A") );
        assertEquals( new Integer(1), t.get("AB") );
	}
    
	public void test10()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        t.put("A",new Integer(0));
        t.put("AB",new Integer(1));
        t.put("ABC",new Integer(2));
        assertEquals( new Integer(0), t.get("A") );
        assertEquals( new Integer(1), t.get("AB") );
        assertEquals( new Integer(2), t.get("ABC") );
	}
	public void test11()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE","zef", "kra","ref","tem","are", "temperature","aren't","zebra","kraken","k","ka","kr"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        for( int i = 0; i < arr.length; ++i )
            assertEquals(new Integer(i),t.get(arr[i]));
	}
    
	public void test12()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE","zef", "kra","ref","tem","are", "temperature","aren't","zebra","kraken","k","ka","kr"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        for( int i = 0; i < arr.length; ++i )
            assertTrue(t.contains(arr[i]));
	}
    
	public void test13()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE","zef", "kra","ref","tem","are", "temperature","aren't","zebra","kraken","k","ka","kr"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        for( int i = 0; i < arr.length; ++i )
            assertFalse(t.contains(arr[i]+"nope"));
	}
    
	public void test14()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE","zef", "kra","ref","tem","are", "temperature","aren't","zebra","kraken","k","ka","kr"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        assertFalse(t.contains("Z"));
        assertFalse(t.contains("0"));
        assertFalse(t.contains("&"));
        assertFalse(t.contains("-"));
        assertFalse(t.contains("R"));
	}
    
    public void test15()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        for( String key: t.keys() )
            fail();
    }
    
    private static boolean inArray(String[] arr, String v)
    {
        for(String s: arr)
        {
            if( s.equals(v) )
                return true;
        }
        return false;
    }
    
	public void test16()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE","zef", "kra","ref","tem","are", "temperature","aren't","zebra","kraken","k","ka","kr"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        HashSet<String> map = new HashSet<String>();
        for( String key: t.keys() )
        {
            assertTrue(inArray(arr,key));
            map.add(key);
        }
        assertEquals(arr.length, map.size());
	}
    
	public void test17()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE","zef", "kra","ref","tem","are", "temperature","aren't","zebra","kraken","k","ka","kr","zef","kra"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        HashSet<String> map = new HashSet<String>();
        for( String key: t.keys() )
        {
            assertTrue(inArray(arr,key));
            map.add(key);
        }
        assertEquals(arr.length - 2, map.size());
	}
    
	public void test18()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE","zef", "kra","ref","tem","are", "temperature","aren't","zebra","kraken","k","ka","kr","zef","kra"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        HashSet<String> map = new HashSet<String>();
        String[] results = {"A","AB","ABC","ABCD","ABCDE"};
        for( String key: t.keysWithPrefix("A") )
        {
            assertTrue(inArray(results,key));
            map.add(key);
        }
        assertEquals(results.length, map.size());
	}
    
	public void test19()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE","zef", "kra","ref","tem","are", "temperature","aren't","zebra","kraken","k","ka","kr","zef","kra"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        HashSet<String> map = new HashSet<String>();
        String[] results = {"AB","ABC","ABCD","ABCDE"};
        for( String key: t.keysWithPrefix("AB") )
        {
            assertTrue(inArray(results,key));
            map.add(key);
        }
        assertEquals(results.length, map.size());
	}
    
	public void test20()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","AB","ABC","ABCD","ABCDE","zef", "kra","ref","tem","are", "temperature","aren't","zebra","kraken","k","ka","kr","zef","kra"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        for( String key: t.keysWithPrefix("ABz") )
        {
            fail();
        }
	}
    
	public void test21()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"a","ab","ac","abc","acc","abd","acd","acde","acdd"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        HashSet<String> map = new HashSet<String>();
        String[] results = {"abc","acc"};
        for( String key: t.keysThatMatch("a.c") )
        {
            assertTrue(inArray(results,key));
            map.add(key);
        }
        assertEquals(results.length, map.size());
	}
    
	public void test22()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"a","ab","ac","abc","acc","abd","acd","acde","acdd"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        HashSet<String> map = new HashSet<String>();
        String[] results = {"abc","abd"};
        for( String key: t.keysThatMatch("ab.") )
        {
            assertTrue(inArray(results,key));
            map.add(key);
        }
        assertEquals(results.length, map.size());
	}
    
	public void test23()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"a","ab","ac","abc","acc","abd","acd","acde","acdd"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        HashSet<String> map = new HashSet<String>();
        String[] results = {"acc","acd"};
        for( String key: t.keysThatMatch(".c.") )
        {
            assertTrue(inArray(results,key));
            map.add(key);
        }
        assertEquals(results.length, map.size());
	}
    
	public void test24()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"a","ab","ac","abc","acc","acce","abd","acd","acde","acdd"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        assertEquals("acce",t.longestPrefixOf("accenture"));
	}
    
	public void test25()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"a","ab","ac","abc","acc","acce","abd","acd","acde","acdd"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        assertEquals("abd",t.longestPrefixOf("abd"));
	}
    
	public void test26()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"a","ab","ac","abc","acc","acce","abd","acd","acde","acdd"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        assertNull(t.longestPrefixOf("zebra"));
	}
    
    public void test27()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"a","ab","ac","abc","acc","acce","abd","acd","acde","acdd"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        assertNull(t.get("zero"));
    }
    
    public void test28()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"a","ab","ac","abc","acc","acce","abd","acd","acde","acdd"};
        for( int i = 0; i < arr.length; ++i )
            t.put(arr[i],new Integer(i));
        assertFalse(t.contains(" "));
    }
    
    public void test29()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.put("\u2202",new Integer(0));
            fail();
        }
        catch( InvalidKeyException e ){}
    }
    
    public void test30()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.put(null,new Integer(0));
            fail();
        }
        catch( InvalidKeyException e ){}
    }
    
    public void test31()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.get("\u2202");
            fail();
        }
        catch( InvalidKeyException e ){}
    }
    
    public void test32()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.get(null);
            fail();
        }
        catch( InvalidKeyException e ){}
    }
    
    public void test33()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.contains("\u2202");
            fail();
        }
        catch( InvalidKeyException e ){}
    }
    
    public void test34()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.contains(null);
            fail();
        }
        catch( InvalidKeyException e ){}
    }
    
    public void test35()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.keysWithPrefix("\u2202");
            fail();
        }
        catch( InvalidKeyException e ){}
    }
    
    public void test36()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.keysWithPrefix(null);
            fail();
        }
        catch( NullPointerException e ){}
    }
    
    public void test37()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.keysThatMatch("\u2202");
            fail();
        }
        catch( InvalidKeyException e ){}
    }
    
    public void test38()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.keysThatMatch(null);
            fail();
        }
        catch( NullPointerException e ){}
    }
    
    public void test39()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.longestPrefixOf("\u2202");
            fail();
        }
        catch( InvalidKeyException e ){}
    }
    
    public void test40()
    {
        HybridTST<Integer> t = new HybridTST<Integer>();
        try
        {
            t.longestPrefixOf(null);
            fail();
        }
        catch( NullPointerException e ){}
    }
    
	public void test41()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","B","C","D","E"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals(1, t.getTreeHeight());
	}
    
	public void test42()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","B","C","D","E","CD"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals(2, t.getTreeHeight());
	}
    
	public void test43()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"she","sells","sea","shells","by","the","sea","shore"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals(6, t.getTreeHeight());
	}
    
	public void test44()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"she","sells","sea","shells","by","the","sea","shore","surely"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals(7, t.getTreeHeight());
	}
    
	public void test45()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"she","sells","sea","shells","by","the","sea","shore","surely","svrely"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals(8, t.getTreeHeight());
	}
	
	public void test46()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","B","C","D","E"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals(0.0, t.getAverageNodeDepth());
	}
    
	public void test47()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"A","B","C","D","E","CD"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals("double value equal to within small delta",(0*5+1)/6.0, t.getAverageNodeDepth(),0.001);
	}
    
	public void test48()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"she","sells","sea","shells","by","the","sea","shore"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals("double value equal to within small delta",(1+4+5+5+5+2+2)/7.0, t.getAverageNodeDepth(),0.001);
	}
    
	public void test49()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"she","sells","sea","shells","by","the","sea","shore","surely"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals("double value equal to within small delta",(1+4+5+5+5+2+2+6)/8.0, t.getAverageNodeDepth(),0.001);
	}
    
	public void test50()
	{
		HybridTST<Integer> t = new HybridTST<Integer>();
        String[] arr = {"she","sells","sea","shells","by","the","sea","shore","surely","svrely"};
        for( String s: arr )
            t.put(s,new Integer(0));
        assertEquals("double value equal to within small delta",(1+4+5+5+5+2+2+6+7)/9.0, t.getAverageNodeDepth(),0.001);
	}
}
