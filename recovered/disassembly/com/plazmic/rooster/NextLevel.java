// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 16
// ########################################################


package com.plazmic.rooster;


abstract final class NextLevel extends com.plazmic.rooster.Mode

{
	// @@@@@@@@@@@@@ Static fields 
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_52058 ; // ofs = 52058 addr = 65)
	private static int /*int*/  field_52064 ; // ofs = 52064 addr = 66)
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_52070 ; // ofs = 52070 addr = 67)
	private static int /*int*/  field_52076 ; // ofs = 52076 addr = 68)

	// @@@@@@@@@@@@@ Fields 
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_51998 ; // ofs = 51998 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_52002 ; // ofs = 52002 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_52006 ; // ofs = 52006 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_52010 ; // ofs = 52010 addr = 0)
	private int /*int*/  field_52014 ; // ofs = 52014 addr = 0)
	private long /*long*/  field_52018 ; // ofs = 52018 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_52022 ; // ofs = 52022 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_52026 ; // ofs = 52026 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image[]*/  field_52030 ; // ofs = 52030 addr = 0)
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_52034 ; // ofs = 52034 addr = 0)
	private com.plazmic.rooster.LevelConfig /*com.plazmic.rooster.LevelConfig*/  field_52038 ; // ofs = 52038 addr = 0)
	private String /*java.lang.String*/  field_52042 ; // ofs = 52042 addr = 0)
	private int /*int*/  field_52046 ; // ofs = 52046 addr = 0)
	private int /*int*/  field_52050 ; // ofs = 52050 addr = 0)
	private String /*java.lang.String*/  field_52054 ; // ofs = 52054 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.NextLevel, com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	xenter 
	aload_0 
	invokespecial com.plazmic.rooster.Mode.<init> // pc=1
	aload_0 
	iconst_0 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	iconst_0 
	i2l 
	lputfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	bipush 19
	newarray_object_lib javax.microedition.lcdui.Image//javax.microedition.lcdui.Image javax.microedition.lcdui.Image javax.microedition.lcdui.Image
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	aload_0 
	new LevelConfig
	dup 
	invokespecial com.plazmic.rooster.LevelConfig.<init> // pc=1
	putfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_43:"Hide"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_46:"Quit Game"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_94:"Continue"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_48:"Close"
	bipush 7
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	ldc literal_95:"img/nextLevel.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	ldc literal_96:"img/nextLevel_spaceToPlay.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	ldc literal_97:"img/levelNames.png"
	invokestatic_lib createImage( java.lang.String ) // 
	astore_2 
	iconst_0 
	istore_3 
	goto Label78
Label65:
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	iload_3 
	aload_2 
	iconst_0 
	iload_3 
	bipush 15
	imul 
	sipush 215
	bipush 15
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	aastore 
	iinc 3 1
Label78:
	iload_3 
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	arraylength 
	if_icmplt Label65
	goto Label89
	astore_3 
	getstatic_lib out // System
	ldc literal_98:"Could not find one of the next level images."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	aload_3 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
Label89:
	aload_0 
	aload_1 
	putfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit Mode
	synch_static NextLevel
	clinit_wait 
	iconst_0 
	iconst_1 
	bipush 8
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.NextLevel.field_52058 // NextLevel
	getstatic com.plazmic.rooster.NextLevel.field_52058 // NextLevel
	invokevirtual getHeight( javax.microedition.lcdui.Font ) // pc=1
	bipush 2
	idiv 
	putstatic com.plazmic.rooster.NextLevel.field_52064 // NextLevel
	iconst_0 
	iconst_1 
	bipush 16
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.NextLevel.field_52070 // NextLevel
	getstatic com.plazmic.rooster.NextLevel.field_52070 // NextLevel
	invokevirtual getHeight( javax.microedition.lcdui.Font ) // pc=1
	bipush 2
	idiv 
	putstatic com.plazmic.rooster.NextLevel.field_52076 // NextLevel
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final setLevel( com.plazmic.rooster.NextLevel, int ); // address: 0
	{
	enter_narrow 
	aload_0 
	iload_1 
	putfield .field_13_13   // get_name_1:  .field_13_13   // get_name_2:  .field_13_13   // get_Name:    .field_13_13   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 13
	aload_0 
	iload_1 
	iconst_1 
	iadd 
	invokestatic_lib toString( int ) // 
	putfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	return 
	}


public final setScore( com.plazmic.rooster.NextLevel, int ); // address: 0
	{
	enter_narrow 
	aload_0 
	aload_0_getfield .field_13_13   // get_name_1:  .field_13_13   // get_name_2:  .field_13_13   // get_Name:    .field_13_13   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 13
	putfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	aload_0 
	iload_1 
	invokestatic_lib toString( int ) // 
	putfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final keyPressed( com.plazmic.rooster.NextLevel, int ); // address: 0
	{
	enter_narrow 
	iload_1 
	bipush 32
	if_icmpeq Label7
	iload_1 
	bipush 48
	if_icmpne Label10
Label7:
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iconst_1 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
Label10:
	return 
	}


public final keyReleased( com.plazmic.rooster.NextLevel, int ); // address: 0
	{
	enter_narrow 
	iload_1 
	bipush 27
	if_icmpne Label7
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	getfield parent   // get_name_1:  parent   // get_name_2:  parent   // get_Name:    parent   // getName->1:  parent   // getName->2:  parent   // getName->N:  parent   // ofs = 52398 ord = 0 addr = 0
	invokevirtual notifyPaused( javax.microedition.midlet.MIDlet ) // pc=1
Label7:
	return 
	}


public final render( com.plazmic.rooster.NextLevel, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_1 
	iconst_0 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_0 
	iconst_0 
	bipush 16
	bipush 4
	ior 
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_1 
	getstatic com.plazmic.rooster.NextLevel.field_52058 // NextLevel
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	iipush 7798784
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	aload_0_getfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	bipush 60
	bipush 82
	getstatic com.plazmic.rooster.NextLevel.field_52064 // NextLevel
	isub 
	bipush 20
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	bipush 62
	bipush 82
	getstatic com.plazmic.rooster.NextLevel.field_52064 // NextLevel
	isub 
	bipush 20
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	bipush 60
	bipush 84
	getstatic com.plazmic.rooster.NextLevel.field_52064 // NextLevel
	isub 
	bipush 20
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	bipush 62
	bipush 84
	getstatic com.plazmic.rooster.NextLevel.field_52064 // NextLevel
	isub 
	bipush 20
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	iipush 16777215
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	aload_0_getfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	bipush 61
	bipush 83
	getstatic com.plazmic.rooster.NextLevel.field_52064 // NextLevel
	isub 
	bipush 20
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	getstatic com.plazmic.rooster.NextLevel.field_52070 // NextLevel
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	iipush 7798784
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	sipush 219
	bipush 82
	getstatic com.plazmic.rooster.NextLevel.field_52076 // NextLevel
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	sipush 221
	bipush 82
	getstatic com.plazmic.rooster.NextLevel.field_52076 // NextLevel
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	sipush 219
	bipush 84
	getstatic com.plazmic.rooster.NextLevel.field_52076 // NextLevel
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	sipush 221
	bipush 84
	getstatic com.plazmic.rooster.NextLevel.field_52076 // NextLevel
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	iipush 16777215
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	sipush 220
	bipush 83
	getstatic com.plazmic.rooster.NextLevel.field_52076 // NextLevel
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	aload_0_getfield .field_13_13   // get_name_1:  .field_13_13   // get_name_2:  .field_13_13   // get_Name:    .field_13_13   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 13
	iconst_1 
	isub 
	aaload 
	bipush 120
	bipush 110
	bipush 17
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_0 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iconst_1 
	iadd 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	bipush 4
	if_icmpge Label129
	return 
Label129:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	bipush 4
	if_icmplt Label142
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	bipush 12
	if_icmpge Label142
	aload_1 
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	bipush 120
	sipush 142
	bipush 3
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	return 
Label142:
	aload_0 
	iconst_0 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	return 
	}


public final setMenu( com.plazmic.rooster.NextLevel ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}


public final unsetMenu( com.plazmic.rooster.NextLevel ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}

}
