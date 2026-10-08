// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 8
// ########################################################


package com.plazmic.rooster;


abstract final class HighScores extends com.plazmic.rooster.Mode

{

	// @@@@@@@@@@@@@ Fields 
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_51232 ; // ofs = 51232 addr = 0)
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_51236 ; // ofs = 51236 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_51240 ; // ofs = 51240 addr = 0)
	private String /*java.lang.String[]*/  field_51244 ; // ofs = 51244 addr = 0)
	private String /*java.lang.String[]*/  field_51248 ; // ofs = 51248 addr = 0)
	private String /*java.lang.String[]*/  field_51252 ; // ofs = 51252 addr = 0)
	private javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_51256 ; // ofs = 51256 addr = 0)
	private javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_51260 ; // ofs = 51260 addr = 0)
	private int /*int*/  field_51264 ; // ofs = 51264 addr = 0)
	private int /*int*/  field_51268 ; // ofs = 51268 addr = 0)
	private int /*int*/  field_51272 ; // ofs = 51272 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.HighScores, com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	xenter 
	aload_0 
	invokespecial com.plazmic.rooster.Mode.<init> // pc=1
	aload_0 
	bipush 10
	newarray_object_lib String//java.lang.String java.lang.String java.lang.String
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	bipush 10
	newarray_object_lib String//java.lang.String java.lang.String java.lang.String
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	bipush 10
	newarray_object_lib String//java.lang.String java.lang.String java.lang.String
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	iconst_0 
	iconst_1 
	bipush 8
	invokestatic_lib getFont( int, int, int ) // 
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0 
	iconst_0 
	iconst_0 
	bipush 8
	invokestatic_lib getFont( int, int, int ) // 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	bipush -1
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	aload_0 
	bipush 20
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	invokevirtual getHeight( javax.microedition.lcdui.Font ) // pc=1
	isub 
	bipush 2
	idiv 
	bipush 57
	iadd 
	putfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_17:"Start Screen"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	ldc literal_60:"img/highScore.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	goto Label59
	astore_2 
	getstatic_lib out // System
	ldc literal_31:"Could not find one of the splash images.  "
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	aload_2 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
Label59:
	aload_0 
	aload_1 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iconst_1 
	istore_2 
	goto Label73
Label65:
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_2 
	iconst_1 
	isub 
	iload_2 
	invokestatic_lib valueOf( int ) // 
	aastore 
	iinc 2 1
Label73:
	iload_2 
	bipush 10
	if_icmple Label65
	return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final init( com.plazmic.rooster.HighScores ); // address: 0
	{
	enter 
	bipush 3
	newarray 3
	astore_2 
	iconst_0 
	istore_3 
	invokestatic byte[] getHighScores(  ) // Storage
	astore_1 
	iconst_0 
	istore_4 
	goto_w Label103
Label11:
	iconst_0 
	istore_3 
	aload_1 
	iload_4 
	bipush 7
	imul 
	iconst_0 
	iadd 
	baload 
	sipush 255
	iand 
	bipush 24
	ishl 
	aload_1 
	iload_4 
	bipush 7
	imul 
	iconst_1 
	iadd 
	baload 
	sipush 255
	iand 
	bipush 16
	ishl 
	ior 
	aload_1 
	iload_4 
	bipush 7
	imul 
	bipush 2
	iadd 
	baload 
	sipush 255
	iand 
	bipush 8
	ishl 
	ior 
	aload_1 
	iload_4 
	bipush 7
	imul 
	bipush 3
	iadd 
	baload 
	sipush 255
	iand 
	ior 
	istore_3 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload_4 
	iload_3 
	invokestatic_lib valueOf( int ) // 
	aastore 
	aload_2 
	iconst_0 
	aload_1 
	iload_4 
	bipush 7
	imul 
	bipush 4
	iadd 
	baload 
	i2c 
	castore 
	aload_2 
	iconst_1 
	aload_1 
	iload_4 
	bipush 7
	imul 
	bipush 5
	iadd 
	baload 
	i2c 
	castore 
	aload_2 
	bipush 2
	aload_1 
	iload_4 
	bipush 7
	imul 
	bipush 6
	iadd 
	baload 
	i2c 
	castore 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_4 
	aload_2 
	invokestatic_lib valueOf( char[] ) // 
	aastore 
	iinc 4 1
Label103:
	iload_4 
	bipush 10
	if_icmpge Label107
	goto_w Label11
Label107:
	aload_0 
	iconst_0 
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	return 
	}


public final setRank( com.plazmic.rooster.HighScores, int ); // address: 0
	{
	putfield_return .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final keyPressed( com.plazmic.rooster.HighScores, int ); // address: 0
	{
	noenter_return 
	}


public final keyReleased( com.plazmic.rooster.HighScores, int ); // address: 0
	{
	enter_narrow 
	iload_1 
	bipush 27
	if_icmpne Label7
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iconst_0 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
Label7:
	return 
	}


public final render( com.plazmic.rooster.HighScores, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_1 
	iipush 15594232
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	iconst_0 
	bipush 52
	sipush 240
	bipush 108
	invokevirtual fillRect( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iconst_0 
	iconst_0 
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_1 
	iipush 10066329
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	bipush 3
	bipush 55
	sipush 234
	bipush 99
	invokevirtual drawRect( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_1 
	iipush 14541544
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	bipush 4
	bipush 56
	sipush 232
	bipush 20
	invokevirtual fillRect( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_1 
	bipush 4
	bipush 96
	sipush 232
	bipush 20
	invokevirtual fillRect( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_1 
	bipush 4
	sipush 136
	sipush 232
	bipush 18
	invokevirtual fillRect( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_1 
	iipush 10066329
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	bipush 120
	bipush 60
	bipush 120
	sipush 150
	invokevirtual drawLine( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_0 
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	bipush 5
	if_icmpge Label66
	aload_0 
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_1 
	iadd 
	dup_x1 
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	goto Label67
Label66:
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
Label67:
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_0 
	istore_2 
	goto Label124
Label71:
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	iload_2 
	if_icmpne Label81
	aload_1 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	iipush 10158337
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	goto Label87
Label81:
	aload_1 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	iipush 4473958
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
Label87:
	aload_1 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_2 
	aaload 
	bipush 20
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_2 
	bipush 20
	imul 
	iadd 
	bipush 24
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_2 
	aaload 
	bipush 25
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_2 
	bipush 20
	imul 
	iadd 
	bipush 20
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload_2 
	aaload 
	bipush 110
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_2 
	bipush 20
	imul 
	iadd 
	bipush 24
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	iinc 2 1
Label124:
	iload_2 
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	if_icmplt Label71
	iconst_0 
	istore_3 
	goto Label191
Label130:
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	iload_3 
	bipush 5
	iadd 
	if_icmpne Label142
	aload_1 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	iipush 10158337
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	goto Label148
Label142:
	aload_1 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	iipush 4473958
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
Label148:
	aload_1 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_3 
	bipush 5
	iadd 
	aaload 
	sipush 140
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_3 
	bipush 20
	imul 
	iadd 
	bipush 24
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_3 
	bipush 5
	iadd 
	aaload 
	sipush 145
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_3 
	bipush 20
	imul 
	iadd 
	bipush 20
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload_3 
	bipush 5
	iadd 
	aaload 
	sipush 230
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_3 
	bipush 20
	imul 
	iadd 
	bipush 24
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	iinc 3 1
Label191:
	iload_3 
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	if_icmplt Label130
	return 
	}


public final setMenu( com.plazmic.rooster.HighScores ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}


public final unsetMenu( com.plazmic.rooster.HighScores ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}

}
