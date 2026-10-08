// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 3
// ########################################################


package com.plazmic.rooster;


abstract final class EnterName extends com.plazmic.rooster.Mode

{
	// @@@@@@@@@@@@@ Static fields 
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_50484 ; // ofs = 50484 addr = 10)
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_50490 ; // ofs = 50490 addr = 11)
	private static byte[] /*byte[]*/  field_50496 ; // ofs = 50496 addr = 12)
	private static byte[] /*byte[]*/  field_50502 ; // ofs = 50502 addr = 13)

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_50444 ; // ofs = 50444 addr = 0)
	private int /*int*/  field_50448 ; // ofs = 50448 addr = 0)
	private int /*int*/  field_50452 ; // ofs = 50452 addr = 0)
	private byte[] /*byte[]*/  field_50456 ; // ofs = 50456 addr = 0)
	private boolean /*boolean*/  field_50460 ; // ofs = 50460 addr = 0)
	private int /*int*/  field_50464 ; // ofs = 50464 addr = 0)
	private int /*int*/  field_50468 ; // ofs = 50468 addr = 0)
	private long /*long*/  field_50472 ; // ofs = 50472 addr = 0)
	private int /*int*/  field_50476 ; // ofs = 50476 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50480 ; // ofs = 50480 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.EnterName, com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	enter_narrow 
	aload_0 
	invokespecial com.plazmic.rooster.Mode.<init> // pc=1
	aload_0 
	bipush 27
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	iconst_0 
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	arrayinit [95, 95, 95]
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	iconst_1 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	iconst_0 
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	iconst_0 
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0 
	iconst_0 
	i2l 
	lputfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	bipush 97
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	aload_0 
	aload_1 
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0 
	ldc literal_24:"img/top10.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	return 
	astore_2 
	getstatic_lib out // System
	ldc literal_25:"Could not find the enter name bg image."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit Mode
	synch_static EnterName
	clinit_wait 
	iconst_0 
	iconst_1 
	bipush 16
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.EnterName.field_50484 // EnterName
	iconst_0 
	iconst_0 
	bipush 8
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.EnterName.field_50490 // EnterName
	arrayinit [83, 78, 86, 70, 82, 70, 72, 72, 73, 75, 75, 76, 77, 78, 80, 80, 87, 82, 83, 89, 73, 86, 87, 88, 89, 88]
	putstatic com.plazmic.rooster.EnterName.field_50496 // EnterName
	arrayinit [32, 101, 116, 117, 100, 103, 106, 99, 98, 109]
	putstatic com.plazmic.rooster.EnterName.field_50502 // EnterName
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final reset( com.plazmic.rooster.EnterName ); // address: 0
	{
	enter_narrow 
	aload_0 
	iconst_0 
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iconst_0 
	bipush 95
	bastore 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iconst_1 
	bipush 95
	bastore 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 2
	bipush 95
	bastore 
	return 
	}


public final setHighScoreInfo( com.plazmic.rooster.EnterName, int, int ); // address: 0
	{
	enter_narrow 
	aload_0 
	iload_1 
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	iload_2 
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final keyPressed( com.plazmic.rooster.EnterName, int ); // address: 0
	{
	enter 
	iload_1 
	bipush 48
	if_icmplt Label13
	iload_1 
	bipush 57
	if_icmpgt Label13
	getstatic com.plazmic.rooster.EnterName.field_50502 // EnterName
	iload_1 
	bipush 48
	isub 
	baload 
	istore_1 
Label13:
	iload_1 
	bipush 10
	if_icmpne Label28
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	invokestatic setHighScore( int, byte[], int ) // Storage
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	bipush 4
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield highScores   // get_name_1:  highScores   // get_name_2:  highScores   // get_Name:    highScores   // getName->1:  highScores   // getName->2:  highScores   // getName->N:  highScores   // ofs = 52446 ord = 12 addr = 0
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	invokenonvirtual com.plazmic.rooster.HighScores.setRank // pc=2
	return 
Label28:
	iload_1 
	bipush 97
	if_icmplt Label50
	iload_1 
	bipush 122
	if_icmpgt Label50
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	iload_1 
	bipush 32
	isub 
	i2b 
	bastore 
	aload_0 
	invokestatic_lib currentTimeMillis(  ) // 
	lputfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	iload_1 
	bipush 97
	isub 
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	return 
Label50:
	iload_1 
	bipush 8
	if_icmpne Label61
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	ifle Label68
	aload_0 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	iconst_1 
	isub 
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	return 
Label61:
	iload_1 
	bipush 32
	if_icmpne Label68
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	bipush 32
	bastore 
Label68:
	return 
	}


public final keyReleased( com.plazmic.rooster.EnterName, int ); // address: 0
	{
	enter_narrow 
	iload_1 
	bipush 27
	if_icmpne Label14
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	bipush 7
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	iconst_1 
	putfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield parent   // get_name_1:  parent   // get_name_2:  parent   // get_Name:    parent   // getName->1:  parent   // getName->2:  parent   // getName->N:  parent   // ofs = 52398 ord = 0 addr = 0
	invokevirtual notifyPaused( javax.microedition.midlet.MIDlet ) // pc=1
Label14:
	aload_0 
	iconst_0 
	i2l 
	lputfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iload_1 
	bipush 8
	if_icmpeq Label29
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	bipush 2
	if_icmpge Label29
	aload_0 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	iconst_1 
	iadd 
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
Label29:
	return 
	}


public final render( com.plazmic.rooster.EnterName, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_0 
	lgetfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_0 
	i2l 
	lcmp 
	ifeq Label25
	invokestatic_lib currentTimeMillis(  ) // 
	aload_0 
	lgetfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	lsub 
	sipush 800
	i2l 
	lcmp 
	ifle Label25
	invokestatic_lib getDeviceName(  ) // 
	ldc literal_21:"71"
	invokenonvirtual_lib java.lang.String.startsWith // pc=2
	ifeq Label25
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	getstatic com.plazmic.rooster.EnterName.field_50496 // EnterName
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	baload 
	bastore 
Label25:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	getstatic com.plazmic.rooster.EnterName.field_50484 // EnterName
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_0 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	ifeq Label41
	iconst_0 
	goto Label42
Label41:
	iconst_1 
Label42:
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	arraylength 
	iconst_1 
	isub 
	istore_2 
	goto Label91
Label49:
	iload_2 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	if_icmpne Label54
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	ifeq Label90
Label54:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iconst_0 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload_2 
	baload 
	i2c 
	bipush 101
	iload_2 
	bipush 20
	imul 
	iadd 
	bipush 91
	bipush 17
	invokevirtual drawChar( javax.microedition.lcdui.Graphics, char, int, int, int ) // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	iipush 16777215
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iload_2 
	baload 
	i2c 
	bipush 100
	iload_2 
	bipush 20
	imul 
	iadd 
	bipush 90
	bipush 17
	invokevirtual drawChar( javax.microedition.lcdui.Graphics, char, int, int, int ) // pc=5
Label90:
	iinc 2 -1
Label91:
	iload_2 
	ifge Label49
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	pop 
	sipush 240
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	bipush 2
	imul 
	isub 
	sipush 160
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	bipush 2
	imul 
	isub 
	invokevirtual flushGraphics( javax.microedition.lcdui.game.GameCanvas, int, int, int, int ) // pc=5
	return 
	}


public final setMenu( com.plazmic.rooster.EnterName ); // address: 0
	{
	noenter_return 
	}


public final unsetMenu( com.plazmic.rooster.EnterName ); // address: 0
	{
	noenter_return 
	}

}
