// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 0
// ########################################################


package com.plazmic.rooster;


abstract final class About extends com.plazmic.rooster.Mode

{
	// @@@@@@@@@@@@@ Static fields 
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_50216 ; // ofs = 50216 addr = 2)

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_50188 ; // ofs = 50188 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_50192 ; // ofs = 50192 addr = 0)
	private javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_50196 ; // ofs = 50196 addr = 0)
	private int /*int*/  field_50200 ; // ofs = 50200 addr = 0)
	private int /*int*/  field_50204 ; // ofs = 50204 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50208 ; // ofs = 50208 addr = 0)
	private int /*int*/  field_50212 ; // ofs = 50212 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.About, com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	xenter 
	aload_0 
	invokespecial com.plazmic.rooster.Mode.<init> // pc=1
	aload_0 
	bipush 32
	iconst_1 
	iconst_0 
	invokestatic_lib getFont( int, int, int ) // 
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	bipush 20
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	iconst_1 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	aload_1 
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0 
	sipush 240
	bipush 2
	idiv 
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_17:"Start Screen"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	ldc literal_18:"img/plazmic-games-c_204x106.gif"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	return 
	astore_2 
	getstatic_lib out // System
	ldc literal_19:"Could not find the plazmic logo.  "
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	aload_2 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit Mode
	synch_static About
	clinit_wait 
	bipush 32
	iconst_0 
	bipush 8
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.About.field_50216 // About
	clinit_return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final keyPressed( com.plazmic.rooster.About, int ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	bipush 3
	if_icmpge Label10
	aload_0 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iconst_1 
	iadd 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	return 
Label10:
	aload_0 
	iconst_1 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iconst_0 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
	}


public final render( com.plazmic.rooster.About, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iconst_1 
	if_icmpne Label9
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iipush 5592439
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	goto Label13
Label9:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iipush 16777215
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
Label13:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 10
	isub 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	pop 
	sipush 240
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 2
	imul 
	isub 
	bipush 20
	iadd 
	aload_0 
	pop 
	sipush 160
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 2
	imul 
	isub 
	invokevirtual fillRect( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iipush 10066363
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 10
	isub 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	pop 
	sipush 240
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	isub 
	bipush 10
	iadd 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	invokevirtual drawLine( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 10
	isub 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 10
	isub 
	aload_0 
	pop 
	sipush 160
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	isub 
	invokevirtual drawLine( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iipush 1118515
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0 
	pop 
	sipush 240
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	isub 
	bipush 10
	iadd 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	pop 
	sipush 240
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	isub 
	bipush 10
	iadd 
	aload_0 
	pop 
	sipush 160
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	isub 
	invokevirtual drawLine( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 10
	isub 
	aload_0 
	pop 
	sipush 160
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	isub 
	aload_0 
	pop 
	sipush 240
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	isub 
	bipush 10
	iadd 
	aload_0 
	pop 
	sipush 160
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	isub 
	invokevirtual drawLine( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iconst_1 
	if_icmpeq Label124
	goto_w Label229
Label124:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iconst_0 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_9:"Rooster"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_1 
	iadd 
	bipush 37
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	getstatic com.plazmic.rooster.About.field_50216 // About
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_10:"Engine Programmer:"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_1 
	iadd 
	bipush 57
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_11:"Spencer Quin"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_1 
	iadd 
	bipush 72
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_12:"Artwork:"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_1 
	iadd 
	bipush 92
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_13:"Tudor Whiteley"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_1 
	iadd 
	bipush 107
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iipush 16777215
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_9:"Rooster"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 36
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	getstatic com.plazmic.rooster.About.field_50216 // About
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_10:"Engine Programmer:"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 56
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_11:"Spencer Quin"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 71
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_12:"Artwork:"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 91
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_13:"Tudor Whiteley"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 106
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	goto Label269
Label229:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	bipush 2
	if_icmpne Label240
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 27
	bipush 17
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	goto Label269
Label240:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	getstatic com.plazmic.rooster.About.field_50216 // About
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iconst_0 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_14:"For feedback and comments"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 55
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_15:"please visit:"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 75
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	ldc literal_16:"http://www.plazmic.com"
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 95
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
Label269:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	pop 
	sipush 240
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 2
	imul 
	isub 
	sipush 160
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 2
	imul 
	isub 
	invokevirtual flushGraphics( javax.microedition.lcdui.game.GameCanvas, int, int, int, int ) // pc=5
	return 
	}


public final setMenu( com.plazmic.rooster.About ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}


public final unsetMenu( com.plazmic.rooster.About ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}

}
