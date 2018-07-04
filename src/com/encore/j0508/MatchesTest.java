package com.encore.j0508;

public class MatchesTest {
   public static void main(String[] args) {
	   String str="";
	          str="a";
	          //str="aa";
	          //str="aaaaaaaaaaaaaaa";
	  
	   //boolean str.matches(String regex);
	   //regex ----> regular expression (Á¤±Ô Ç¥Çö½Ä)
	   //regex¸¦ ÅëÇØ Àü´ŞµÇ´Â ÆĞÅÏ¿¡ strÀÌ ºÎÇÕ(match)µÈ´Ù¸é true¸¦ ¸®ÅÏ.
	   
	   //ÃâÇöÈ½¼ö¿¡ °ü·ÃµÈ ºÎÈ£: ?, *, +
	   System.out.println(str.matches("[a]")); //a¹®ÀÚ: ÇÑ¹ø
	   System.out.println(str.matches("[a]?")); //a¹®ÀÚ: 0,1
	   System.out.println(str.matches("[a]*")); //a¹®ÀÚ: 0~¹«ÇÑ´ë
	   System.out.println(str.matches("[a]+")); //a¹®ÀÚ: 1~¹«ÇÑ´ë
	   System.out.println("========================");
	   System.out.println(str.matches("[abc]"));//a ¶Ç´Â b ¶Ç´Â c ¹®ÀÚ Áß 1¹ø ÃâÇö
	   
	   String name="gildongA";
	   //nameº¯¼ö¿¡ ´ëÇÑ ¿µ¹®ÀÚ Ã¼Å©!!
	   System.out.println("ÀÌ¸§Ã¼Å©: "+ 
	         //name.matches("[abcdefghijklmnopqrstuvwxyz]+"));
			   name.matches("[a-zA-Z]+")); //[]¾È¿¡¼­ '-'´Â ¹üÀ§¸¦ Ç¥Çö
	   
	   String su="345678a";
	   //suº¯¼ö¿¡ ´ëÇÑ ¼ıÀÚ Ã¼Å©!!
	   System.out.println("¼ıÀÚÃ¼Å©: "+ su.matches("[0-9]+"));
	   
	   String hangul="³ªÇÑ±Û";
	   //hangulº¯¼ö¿¡ ´ëÇÑ ÇÑ±Û Ã¼Å©!!
	   System.out.println("ÇÑ±ÛÃ¼Å©: "+ hangul.matches("[¤¡-ÆR]+"));
	   
	   String id="gildong100456";
	   //idº¯¼ö´Â 8~12ÀÚ¸®, ¿µ¹®ÀÚ¿Í ¼ıÀÚÁ¶ÇÕ
	   
	   String idPattern="[a-zA-Z0-9]{8,12}";//8~12
	   //{8,12}  8ÀÌ»ó~12ÀÌÇÏ    {8,}: 8ÀÌ»ó    {8} : 8¹ø
	   System.out.println("¾ÆÀÌµğÃ¼Å©: "+ id.matches(idPattern));
	   
	   String juminBunho = "960302-1012345";
	   String juminPattern = "[0-9]{6}-[\\d]{7}";
	   System.out.println("ÁÖ¹Î¹øÈ£Ã¼Å©: "+ juminBunho.matches(juminPattern));
	   
	   String test="1";
	   System.out.println(test.matches("^[0-9-[1]]+$"));
	   
   }//main
}







