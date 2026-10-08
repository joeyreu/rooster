// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 24
// ########################################################


package com.plazmic.rooster;


abstract final class TiledLayer extends com.plazmic.rooster.Layer

{
	// @@@@@@@@@@@@@ Static fields 
	private final static com.plazmic.rooster.LevelConfig /*com.plazmic.rooster.LevelConfig*/  field_53026 ; // ofs = 53026 addr = 90)

	// @@@@@@@@@@@@@ Fields 
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image[]*/  field_53002 ; // ofs = 53002 addr = 0)
	private int[][] /*int[][]*/  field_53006 ; // ofs = 53006 addr = 0)
	private int /*int*/  field_53010 ; // ofs = 53010 addr = 0)
	private int /*int*/  field_53014 ; // ofs = 53014 addr = 0)
	private int /*int*/  field_53018 ; // ofs = 53018 addr = 0)
	private int /*int*/  field_53022 ; // ofs = 53022 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.TiledLayer, int, int, javax.microedition.lcdui.Image, int, int ); // address: 0
	{
	enter 
	aload_0 
	invokespecial com.plazmic.rooster.Layer.<init> // pc=1
	aload_0 
	bipush 20
	newarray_object_lib javax.microedition.lcdui.Image//javax.microedition.lcdui.Image javax.microedition.lcdui.Image javax.microedition.lcdui.Image
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	bipush 30
	bipush 30
	multianewarray  // dim=2 nest=2 type=5
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_3 
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	iload_4 
	idiv 
	istore_6 
	aload_3 
	invokevirtual getHeight( javax.microedition.lcdui.Image ) // pc=1
	iload_5 
	idiv 
	istore_7 
	aload_0 
	iload_1 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	iload_2 
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0 
	iload_4 
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	aload_0 
	iload_5 
	putfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_6 
	iconst_1 
	isub 
	istore 8
	goto Label66
Label39:
	iload_7 
	iconst_1 
	isub 
	istore 9
	goto Label63
Label44:
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload 8
	iload_6 
	imul 
	iload 9
	iadd 
	aload_3 
	iload 8
	iload_4 
	imul 
	iload 9
	iload_5 
	imul 
	iload_4 
	iload_5 
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	aastore 
	iinc 9 -1
Label63:
	iload 9
	ifge Label44
	iinc 8 -1
Label66:
	iload 8
	ifge Label39
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit Layer
	synch_static TiledLayer
	clinit_wait 
	new LevelConfig
	dup 
	invokespecial com.plazmic.rooster.LevelConfig.<init> // pc=1
	putstatic com.plazmic.rooster.TiledLayer.field_53026 // TiledLayer
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final setCell( com.plazmic.rooster.TiledLayer, int, int, int ); // address: 0
	{
	enter 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_1 
	aaload 
	iload_2 
	iload_3 
	iconst_1 
	isub 
	iastore 
	return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final int getHeight( com.plazmic.rooster.TiledLayer ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	imul 
	ireturn 
	}


public final paint( com.plazmic.rooster.TiledLayer, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_1 
	isub 
	istore_2 
	goto Label31
Label6:
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_1 
	isub 
	istore_3 
	goto Label28
Label11:
	aload_1 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_2 
	aaload 
	iload_3 
	iaload 
	aaload 
	iload_2 
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	imul 
	iload_3 
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	imul 
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	iinc 3 -1
Label28:
	iload_3 
	ifge Label11
	iinc 2 -1
Label31:
	iload_2 
	ifge Label6
	return 
	}

}
