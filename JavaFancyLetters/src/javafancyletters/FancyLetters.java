package javafancyletters;

//there are 26+26 letters in each font in unicode.  They are exactly 52 characters away from each other.
class FancyLetters{
	public static void main(String[] arg){
		for(int index=0; index<13; index++){
			System.out.println(getFancy(arg[0], index));
		}
	}


	public static String getFancy(String letters, int font){
		String toReturn = "";
		byte[] bites = letters.getBytes();

		for(int i=0; i<bites.length; i++){
			int bite = bites[i];

			if(bite<65 || bite>65+25 && bite<97 || bite>97+25){
				toReturn += letters.charAt(i);
				continue;
			}			
			
			char kar;
			if(bite >= 97){ //what ever the opposite of capitals is
				kar = (char)('\uDC1A' + bite - 97 + 52*font);

			} else{ //capitals
				kar = (char)('\uDC00' + bite - 65 + 52*font);
			}
			
			toReturn += '\uD835';
			toReturn += kar;
		}

		return toReturn;
	}
} 
/*
𝐂𝐡𝐞𝐚𝐩 𝐨𝐫 𝐟𝐨𝐫 𝐅𝐫𝐞𝐞
𝐶𝑕𝑒𝑎𝑝 𝑜𝑟 𝑓𝑜𝑟 𝐹𝑟𝑒𝑒
𝑪𝒉𝒆𝒂𝒑 𝒐𝒓 𝒇𝒐𝒓 𝑭𝒓𝒆𝒆
𝒞𝒽𝒺𝒶𝓅 𝓄𝓇 𝒻𝓄𝓇 𝒡𝓇𝒺𝒺
𝓒𝓱𝓮𝓪𝓹 𝓸𝓻 𝓯𝓸𝓻 𝓕𝓻𝓮𝓮
𝔆𝔥𝔢𝔞𝔭 𝔬𝔯 𝔣𝔬𝔯 𝔉𝔯𝔢𝔢
𝔺𝕙𝕖𝕒𝕡 𝕠𝕣 𝕗𝕠𝕣 𝔽𝕣𝕖𝕖
𝕮𝖍𝖊𝖆𝖕 𝖔𝖗 𝖋𝖔𝖗 𝕱𝖗𝖊𝖊
𝖢𝗁𝖾𝖺𝗉 𝗈𝗋 𝖿𝗈𝗋 𝖥𝗋𝖾𝖾
𝗖𝗵𝗲𝗮𝗽 𝗼𝗿 𝗳𝗼𝗿 𝗙𝗿𝗲𝗲
𝘊𝘩𝘦𝘢𝘱 𝘰𝘳 𝘧𝘰𝘳 𝘍𝘳𝘦𝘦
𝘾𝙝𝙚𝙖𝙥 𝙤𝙧 𝙛𝙤𝙧 𝙁𝙧𝙚𝙚
𝙲𝚑𝚎𝚊𝚙 𝚘𝚛 𝚏𝚘𝚛 𝙵𝚛𝚎𝚎
*/
