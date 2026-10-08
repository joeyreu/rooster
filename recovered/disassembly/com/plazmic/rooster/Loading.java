// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 14
// ########################################################


package com.plazmic.rooster;


abstract final class Loading extends com.plazmic.rooster.Mode

{
	// @@@@@@@@@@@@@ Static fields 
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_51872 ; // ofs = 51872 addr = 60)

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_51836 ; // ofs = 51836 addr = 0)
	private String /*java.lang.String*/  field_51840 ; // ofs = 51840 addr = 0)
	private float /*float*/  field_51844 ; // ofs = 51844 addr = 0)
	private int /*int*/  field_51848 ; // ofs = 51848 addr = 0)
	private int /*int*/  field_51852 ; // ofs = 51852 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_51856 ; // ofs = 51856 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_51860 ; // ofs = 51860 addr = 0)
	private boolean /*boolean*/  field_51864 ; // ofs = 51864 addr = 0)
	private int /*int*/  field_51868 ; // ofs = 51868 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.Loading, com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	enter_narrow 
	aload_0 
	invokespecial com.plazmic.rooster.Mode.<init> // pc=1
	aload_0 
	ldc literal_90:"Now Loading"
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	isreal 
	bipush 0
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	iconst_0 
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	bipush 40
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	bipush 19
	getstatic com.plazmic.rooster.Loading.field_51872 // Loading
	invokevirtual getHeight( javax.microedition.lcdui.Font ) // pc=1
	isub 
	bipush 2
	idiv 
	bipush 69
	iadd 
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0 
	aload_1 
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0 
	ldc literal_91:"img/loaderBack.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	ldc literal_92:"img/loaderFront.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	return 
	astore_2 
	getstatic_lib out // System
	ldc literal_93:"Could not find one of the loading images."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	aload_2 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit Mode
	synch_static Loading
	clinit_wait 
	iconst_0 
	iconst_0 
	bipush 8
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.Loading.field_51872 // Loading
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final setMessage( com.plazmic.rooster.Loading, java.lang.String ); // address: 0
	{
	enter_narrow 
	aload_0 
	aload_1 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iconst_1 
	iadd 
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	return 
	}


public final setBarIncrements( com.plazmic.rooster.Loading, int ); // address: 0
	{
	enter 
	aload_0 
	aload_0 
	pop 
	sipush 240
	bipush 2
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	bipush 11
	iadd 
	imul 
	isub 
	op01xx 
	i2f 
	iload_1 
	op01xx 
	i2f 
	op01xx 
	fdiv 
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	return 
	}


public final increment( com.plazmic.rooster.Loading ); // address: 0
	{
	enter_narrow 
	aload_0 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iconst_1 
	iadd 
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	return 
	}


public final reset( com.plazmic.rooster.Loading ); // address: 0
	{
	enter_narrow 
	aload_0 
	iconst_0 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	iconst_0 
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final keyPressed( com.plazmic.rooster.Loading, int ); // address: 0
	{
	noenter_return 
	}


public final keyReleased( com.plazmic.rooster.Loading, int ); // address: 0
	{
	noenter_return 
	}


public final render( com.plazmic.rooster.Loading, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	ifne Label13
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	bipush 46
	bipush 67
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_0 
	iconst_1 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
Label13:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iconst_0 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	bipush 51
	bipush 70
	sipush 137
	bipush 19
	invokevirtual fillRect( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iipush 9437441
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	bipush 51
	bipush 70
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	op01xx 
	i2f 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	op01xx 
	fmul 
	op01xx 
	f2i 
	iconst_1 
	isub 
	bipush 19
	invokevirtual fillRect( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 51
	bipush 70
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	getstatic com.plazmic.rooster.Loading.field_51872 // Loading
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iipush 16777215
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	pop 
	sipush 240
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	bipush 2
	imul 
	isub 
	sipush 160
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	bipush 2
	imul 
	isub 
	invokevirtual flushGraphics( javax.microedition.lcdui.game.GameCanvas, int, int, int, int ) // pc=5
	return 
	}


public final setMenu( com.plazmic.rooster.Loading ); // address: 0
	{
	noenter_return 
	}


public final unsetMenu( com.plazmic.rooster.Loading ); // address: 0
	{
	noenter_return 
	}

}
