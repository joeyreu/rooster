// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 2
// ########################################################


package com.plazmic.rooster;


abstract final class Confirm extends com.plazmic.rooster.Mode

{
	// @@@@@@@@@@@@@ Static fields 
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_50372 ; // ofs = 50372 addr = 7)

	// @@@@@@@@@@@@@ Fields 
	private short /*short*/  field_50348 ; // ofs = 50348 addr = 0)
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_50352 ; // ofs = 50352 addr = 0)
	private int /*int*/  field_50356 ; // ofs = 50356 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50360 ; // ofs = 50360 addr = 0)
	private boolean /*boolean*/  field_50364 ; // ofs = 50364 addr = 0)
	private int /*int*/  field_50368 ; // ofs = 50368 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.Confirm, com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	enter_narrow 
	aload_0 
	invokespecial com.plazmic.rooster.Mode.<init> // pc=1
	aload_0 
	bipush 30
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	iconst_0 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	aload_1 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	ldc literal_22:"img/reallyQuit.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	return 
	astore_2 
	getstatic_lib out // System
	ldc literal_23:"Could not find the "really quit" image."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit Mode
	synch_static Confirm
	clinit_wait 
	iconst_0 
	iconst_1 
	bipush 16
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.Confirm.field_50372 // Confirm
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final setUsage( com.plazmic.rooster.Confirm, short ); // address: 0
	{
	putfield_return .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	}


public final short getUsage( com.plazmic.rooster.Confirm ); // address: 0
	{
	ireturn_field .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	}


public final setPreviousMode( com.plazmic.rooster.Confirm, int ); // address: 0
	{
	putfield_return .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	}


public final reset( com.plazmic.rooster.Confirm ); // address: 0
	{
	enter_narrow 
	aload_0 
	iconst_0 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final keyPressed( com.plazmic.rooster.Confirm, int ); // address: 0
	{
	enter 
	invokestatic_lib getPlatformVersion(  ) // 
	ldc literal_20:"1.8"
	invokenonvirtual_lib java.lang.String.startsWith // pc=2
	istore_2 
	invokestatic_lib getDeviceName(  ) // 
	ldc literal_21:"71"
	invokenonvirtual_lib java.lang.String.startsWith // pc=2
	istore_3 
	iload_1 
	bipush 121
	if_icmpeq Label22
	iload_3 
	ifeq Label39
	iload_1 
	bipush 50
	if_icmpeq Label22
	iload_2 
	ifeq Label39
	iload_1 
	bipush 116
	if_icmpne Label39
Label22:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	ifne Label28
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iconst_0 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label28:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iconst_1 
	if_icmpne Label35
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iconst_1 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label35:
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	getfield parent   // get_name_1:  parent   // get_name_2:  parent   // get_Name:    parent   // getName->1:  parent   // getName->2:  parent   // getName->N:  parent   // ofs = 52398 ord = 0 addr = 0
	invokevirtual notifyDestroyed( javax.microedition.midlet.MIDlet ) // pc=1
	return 
Label39:
	iload_1 
	bipush 110
	if_icmpeq Label52
	iload_3 
	ifeq Label58
	iload_1 
	bipush 56
	if_icmpeq Label52
	iload_2 
	ifeq Label58
	iload_1 
	bipush 98
	if_icmpne Label58
Label52:
	aload_0 
	iconst_0 
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
Label58:
	return 
	}


public final keyReleased( com.plazmic.rooster.Confirm, int ); // address: 0
	{
	noenter_return 
	}


public final render( com.plazmic.rooster.Confirm, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	ifne Label12
	aload_1 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 120
	bipush 80
	bipush 3
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_0 
	iconst_1 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
Label12:
	return 
	}


public final setMenu( com.plazmic.rooster.Confirm ); // address: 0
	{
	noenter_return 
	}


public final unsetMenu( com.plazmic.rooster.Confirm ); // address: 0
	{
	noenter_return 
	}

}
