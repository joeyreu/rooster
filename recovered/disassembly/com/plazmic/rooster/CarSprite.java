// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 1
// ########################################################


package com.plazmic.rooster;


abstract final class CarSprite extends com.plazmic.rooster.Sprite

{

	// @@@@@@@@@@@@@ Fields 
	public int /*int*/  speed ; // ofs = 50280 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.CarSprite, javax.microedition.lcdui.Image ); // address: 0
	{
	enter_narrow 
	aload_0 
	aload_1 
	iconst_1 
	invokespecial com.plazmic.rooster.Sprite.<init> // pc=3
	return 
	}


public final <init>( com.plazmic.rooster.CarSprite, javax.microedition.lcdui.Image, javax.microedition.lcdui.Image ); // address: 0
	{
	jumpspecial <init>( com.plazmic.rooster.Sprite, javax.microedition.lcdui.Image, javax.microedition.lcdui.Image )
	}


public final <init>( com.plazmic.rooster.CarSprite, javax.microedition.lcdui.Image, int, int ); // address: 0
	{
	enter 
	aload_0 
	aload_1 
	iload_2 
	iload_3 
	iconst_1 
	invokespecial com.plazmic.rooster.Sprite.<init> // pc=5
	return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final setSpeed( com.plazmic.rooster.CarSprite, int ); // address: 0
	{
	putfield_return .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	}


public final move( com.plazmic.rooster.CarSprite ); // address: 0
	{
	enter_narrow 
	aload_0 
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Layer.move // pc=3
	return 
	}

}
