// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 11
// ########################################################


package com.plazmic.rooster;


abstract final class LayerManager extends Object

{

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.Layer /*com.plazmic.rooster.Layer[]*/  field_51556 ; // ofs = 51556 addr = 0)
	private int /*int*/  field_51560 ; // ofs = 51560 addr = 0)
	private int[] /*int[]*/  field_51564 ; // ofs = 51564 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

final <init>( com.plazmic.rooster.LayerManager ); // address: 0
	{
	enter_narrow 
	aload_0 
	invokespecial_lib java.lang.Object.<init> // pc=1
	aload_0 
	bipush 100
	newarray_object Layer
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0 
	iconst_0 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -16, 0, 0, 0, -96, 0, 0, 0]
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final append( com.plazmic.rooster.LayerManager, com.plazmic.rooster.Layer ); // address: 0
	{
	enter 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	dup_x1 
	iconst_1 
	iadd 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_1 
	aastore 
	return 
	}


public final paint( com.plazmic.rooster.LayerManager, javax.microedition.lcdui.Graphics, int, int ); // address: 0
	{
	enter 
	aload_1 
	iload_2 
	iload_3 
	ineg 
	invokevirtual translate( javax.microedition.lcdui.Graphics, int, int ) // pc=3
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iconst_1 
	isub 
	istore_4 
	goto Label17
Label11:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iload_4 
	aaload 
	aload_1 
	invokevirtual_short .virtual_3 // idx=3 pc=2
	iinc 4 -1
Label17:
	iload_4 
	ifge Label11
	aload_1 
	iload_2 
	iload_3 
	invokevirtual translate( javax.microedition.lcdui.Graphics, int, int ) // pc=3
	return 
	}


public final clear( com.plazmic.rooster.LayerManager ); // address: 0
	{
	enter_narrow 
	aload_0 
	iconst_0 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	return 
	}

}
