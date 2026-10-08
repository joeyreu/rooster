// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 7
// ########################################################


package com.plazmic.rooster;


abstract final class HUD extends Object

{
	// @@@@@@@@@@@@@ Static fields 
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_51160 ; // ofs = 51160 addr = 28)

	// @@@@@@@@@@@@@ Fields 
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_51128 ; // ofs = 51128 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_51132 ; // ofs = 51132 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_51136 ; // ofs = 51136 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image[][]*/  field_51140 ; // ofs = 51140 addr = 0)
	private int /*int*/  field_51144 ; // ofs = 51144 addr = 0)
	private int /*int*/  field_51148 ; // ofs = 51148 addr = 0)
	private int /*int*/  field_51152 ; // ofs = 51152 addr = 0)
	private com.plazmic.rooster.LevelConfig /*com.plazmic.rooster.LevelConfig*/  field_51156 ; // ofs = 51156 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.HUD ); // address: 0
	{
	xenter 
	aload_0 
	invokespecial_lib java.lang.Object.<init> // pc=1
	aload_0 
	bipush 2
	bipush 10
	multianewarray_object_lib Image
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	iconst_0 
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	iconst_0 
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0 
	new LevelConfig
	dup 
	invokespecial com.plazmic.rooster.LevelConfig.<init> // pc=1
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	ldc literal_55:"img/hudBL.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0 
	ldc literal_56:"img/newHUDLeft.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iconst_0 
	iconst_0 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual getHeight( javax.microedition.lcdui.Image ) // pc=1
	bipush 2
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	ldc literal_57:"img/numbers10_8_black.png"
	invokestatic_lib createImage( java.lang.String ) // 
	astore_1 
	iconst_0 
	istore_2 
	goto Label63
Label44:
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iconst_0 
	aaload 
	iload_2 
	iconst_1 
	iadd 
	bipush 10
	irem 
	aload_1 
	iload_2 
	bipush 7
	imul 
	iconst_0 
	bipush 7
	bipush 8
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	aastore 
	iinc 2 1
Label63:
	iload_2 
	bipush 10
	if_icmplt Label44
	ldc literal_58:"img/numbers10_8_white.png"
	invokestatic_lib createImage( java.lang.String ) // 
	astore_1 
	iconst_0 
	istore_3 
	goto Label91
Label72:
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iconst_1 
	aaload 
	iload_3 
	iconst_1 
	iadd 
	bipush 10
	irem 
	aload_1 
	iload_3 
	bipush 7
	imul 
	iconst_0 
	bipush 7
	bipush 8
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	aastore 
	iinc 3 1
Label91:
	iload_3 
	bipush 10
	if_icmplt Label72
	return 
	astore_2 
	getstatic_lib out // System
	ldc literal_59:"Could not load one or more of the HUD images."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	synch_static HUD
	clinit_wait 
	bipush 64
	iconst_0 
	bipush 8
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.HUD.field_51160 // HUD
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final decrementCarCount( com.plazmic.rooster.HUD, int ); // address: 0
	{
	enter_narrow 
	aload_0 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_1 
	isub 
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	return 
	}


public final drawNumbers( com.plazmic.rooster.HUD, javax.microedition.lcdui.Graphics, java.lang.String, int, int, int, int ); // address: 0
	{
	enter 
	getstatic HUDFontColour // LevelConfig
	iload_3 
	iaload 
	istore 9
	iconst_0 
	istore 10
	goto Label69
Label8:
	aload_2 
	iload 10
	stringaload 
	bipush 48
	isub 
	istore_7 
	iload_6 
	bipush 24
	if_icmpne Label49
	iload_4 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload 9
	aaload 
	iconst_0 
	aaload 
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	aload_2 
	stringlength 
	imul 
	isub 
	istore 8
	aload_1 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload 9
	aaload 
	iload_7 
	aaload 
	iload 8
	iload 10
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload 9
	aaload 
	iload_7 
	aaload 
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	imul 
	iadd 
	iload_5 
	iload_6 
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	goto Label68
Label49:
	aload_1 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload 9
	aaload 
	iload_7 
	aaload 
	iload_4 
	iload 10
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload 9
	aaload 
	iload_7 
	aaload 
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	imul 
	iadd 
	iload_5 
	iload_6 
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
Label68:
	iinc 10 1
Label69:
	iload 10
	aload_2 
	stringlength 
	if_icmplt Label8
	return 
	}


public final paint( com.plazmic.rooster.HUD, javax.microedition.lcdui.Graphics, int ); // address: 0
	{
	enter 
	aload_1 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iconst_0 
	sipush 160
	bipush 36
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iconst_0 
	iconst_0 
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	sipush 240
	iconst_0 
	bipush 24
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_0 
	aload_1 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	invokestatic_lib valueOf( int ) // 
	iload_2 
	sipush 242
	iconst_1 
	bipush 24
	invokenonvirtual com.plazmic.rooster.HUD.drawNumbers // pc=7
	aload_0 
	aload_1 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	invokestatic_lib valueOf( int ) // 
	iload_2 
	iconst_1 
	iconst_1 
	bipush 20
	invokenonvirtual com.plazmic.rooster.HUD.drawNumbers // pc=7
	aload_0 
	aload_1 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	invokestatic_lib valueOf( int ) // 
	iload_2 
	bipush 17
	sipush 157
	bipush 36
	invokenonvirtual com.plazmic.rooster.HUD.drawNumbers // pc=7
	return 
	}


public final setLives( com.plazmic.rooster.HUD, int ); // address: 0
	{
	putfield_return .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	}


public final setCarCount( com.plazmic.rooster.HUD, int ); // address: 0
	{
	putfield_return .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	}


public final int getCarCount( com.plazmic.rooster.HUD ); // address: 0
	{
	ireturn_field .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	}


public final addToScore( com.plazmic.rooster.HUD, int ); // address: 0
	{
	enter_narrow 
	aload_0 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_1 
	iadd 
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	return 
	}


public final resetScore( com.plazmic.rooster.HUD ); // address: 0
	{
	enter_narrow 
	aload_0 
	iconst_0 
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	return 
	}


public final int getScore( com.plazmic.rooster.HUD ); // address: 0
	{
	ireturn_field .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	}

}
