// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 13
// ########################################################


package com.plazmic.rooster;


abstract final class Levels extends Object

{
	// @@@@@@@@@@@@@ Static fields 
	private final static com.plazmic.rooster.LevelConfig /*com.plazmic.rooster.LevelConfig*/  field_51764 ; // ofs = 51764 addr = 57)

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.TiledLayer /*com.plazmic.rooster.TiledLayer*/  field_51756 ; // ofs = 51756 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_51760 ; // ofs = 51760 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.Levels, int, com.plazmic.rooster.Loading ); // address: 0
	{
	xenter 
	aload_0 
	invokespecial_lib java.lang.Object.<init> // pc=1
	aload_0 
	new_lib StringBuffer//java.lang.StringBuffer java.lang.StringBuffer java.lang.StringBuffer
	dup 
	ldc literal_32:"img/"
	invokespecial_lib java.lang.StringBuffer.<init> // pc=2
	getstatic imageNames // LevelConfig
	iload_1 
	aaload 
	invokevirtual append( java.lang.StringBuffer, java.lang.String ) // pc=2
	invokevirtual_short .toString // idx=2 pc=1
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	new TiledLayer
	dup 
	iconst_1 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	sipush 240
	bipush 15
	invokespecial com.plazmic.rooster.TiledLayer.<init> // pc=6
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iconst_0 
	istore_3 
	goto Label43
Label31:
	aload_2 
	invokenonvirtual com.plazmic.rooster.Loading.increment // pc=1
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iconst_0 
	iload_3 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	iload_3 
	iaload 
	invokenonvirtual com.plazmic.rooster.TiledLayer.setCell // pc=4
	iinc 3 1
Label43:
	iload_3 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	if_icmplt Label31
	return 
	astore_3 
	getstatic_lib out // System
	ldc literal_89:"One or more of the level tiles could not be loaded."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	synch_static Levels
	clinit_wait 
	new LevelConfig
	dup 
	invokespecial com.plazmic.rooster.LevelConfig.<init> // pc=1
	putstatic com.plazmic.rooster.Levels.field_51764 // Levels
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final reset( com.plazmic.rooster.Levels, int, com.plazmic.rooster.Loading, boolean ); // address: 0
	{
	xenter 
	iload_1 
	ifeq Label15
	iload_3 
	ifne Label15
	getstatic imageNames // LevelConfig
	iload_1 
	iconst_1 
	isub 
	aaload 
	getstatic imageNames // LevelConfig
	iload_1 
	aaload 
	invokevirtual_short .equals // idx=1 pc=2
	ifne Label27
Label15:
	aload_0 
	new_lib StringBuffer//java.lang.StringBuffer java.lang.StringBuffer java.lang.StringBuffer
	dup 
	ldc literal_32:"img/"
	invokespecial_lib java.lang.StringBuffer.<init> // pc=2
	getstatic imageNames // LevelConfig
	iload_1 
	aaload 
	invokevirtual append( java.lang.StringBuffer, java.lang.String ) // pc=2
	invokevirtual_short .toString // idx=2 pc=1
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
Label27:
	aload_0 
	new TiledLayer
	dup 
	iconst_1 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	sipush 240
	bipush 15
	invokespecial com.plazmic.rooster.TiledLayer.<init> // pc=6
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iconst_0 
	istore_4 
	goto Label55
Label43:
	aload_2 
	invokenonvirtual com.plazmic.rooster.Loading.increment // pc=1
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iconst_0 
	iload_4 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	iload_4 
	iaload 
	invokenonvirtual com.plazmic.rooster.TiledLayer.setCell // pc=4
	iinc 4 1
Label55:
	iload_4 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	if_icmplt Label43
	return 
	astore_4 
	getstatic_lib out // System
	ldc literal_89:"One or more of the level tiles could not be loaded."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}


final com.plazmic.rooster.TiledLayer getLevel( com.plazmic.rooster.Levels ); // address: 0
	{
	areturn_field .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	}

}
