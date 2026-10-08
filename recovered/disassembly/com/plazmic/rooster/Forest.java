// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 5
// ########################################################


package com.plazmic.rooster;


abstract final class Forest extends Object

{
	// @@@@@@@@@@@@@ Static fields 
	private final static com.plazmic.rooster.LevelConfig /*com.plazmic.rooster.LevelConfig*/  field_50720 ; // ofs = 50720 addr = 19)

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.LayerManager /*com.plazmic.rooster.LayerManager*/  field_50680 ; // ofs = 50680 addr = 0)
	private java.util.Random /*java.util.Random*/  field_50684 ; // ofs = 50684 addr = 0)
	private int /*int*/  field_50688 ; // ofs = 50688 addr = 0)
	private int /*int*/  field_50692 ; // ofs = 50692 addr = 0)
	private com.plazmic.rooster.Sprite /*com.plazmic.rooster.Sprite[][]*/  field_50696 ; // ofs = 50696 addr = 0)
	private int[] /*int[]*/  field_50700 ; // ofs = 50700 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image[]*/  field_50704 ; // ofs = 50704 addr = 0)
	private int /*int*/  field_50708 ; // ofs = 50708 addr = 0)
	private int[] /*int[]*/  field_50712 ; // ofs = 50712 addr = 0)
	private int /*int*/  field_50716 ; // ofs = 50716 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.Forest, int, int, int, com.plazmic.rooster.Loading ); // address: 0
	{
	enter 
	aload_0 
	invokespecial_lib java.lang.Object.<init> // pc=1
	aload_0 
	new LayerManager
	dup 
	invokespecial com.plazmic.rooster.LayerManager.<init> // pc=1
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0 
	new_lib java.util.Random//java.util.Random java.util.Random java.util.Random
	dup 
	invokespecial_lib java.util.Random.<init> // pc=1
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	bipush 30
	bipush 10
	multianewarray_object Sprite
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	bipush 30
	newarray 5
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	bipush 3
	newarray_object_lib javax.microedition.lcdui.Image//javax.microedition.lcdui.Image javax.microedition.lcdui.Image javax.microedition.lcdui.Image
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0 
	bipush 30
	newarray 5
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_0 
	istore_6 
	aload_0 
	iload_2 
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	iload_3 
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	iload_1 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	iload_1 
	invokenonvirtual com.plazmic.rooster.Forest.setImages // pc=2
	iconst_0 
	istore_7 
	goto Label68
Label47:
	iconst_0 
	istore 8
	goto Label64
Label50:
	new Sprite
	dup 
	invokespecial com.plazmic.rooster.Sprite.<init> // pc=1
	astore_5 
	aload_5 
	iconst_1 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_7 
	aaload 
	iload 8
	aload_5 
	aastore 
	iinc 8 1
Label64:
	iload 8
	bipush 10
	if_icmplt Label50
	iinc 7 1
Label68:
	iload_7 
	bipush 30
	if_icmplt Label47
	aload_0 
	iload_1 
	aload_4 
	invokenonvirtual com.plazmic.rooster.Forest.makeTrees // pc=3
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	synch_static Forest
	clinit_wait 
	new LevelConfig
	dup 
	invokespecial com.plazmic.rooster.LevelConfig.<init> // pc=1
	putstatic com.plazmic.rooster.Forest.field_50720 // Forest
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final makeTrees( com.plazmic.rooster.Forest, int, com.plazmic.rooster.Loading ); // address: 0
	{
	enter 
	iconst_0 
	istore_6 
	bipush 3
	getstatic treeDensity // LevelConfig
	iload_1 
	iaload 
	multianewarray_object Sprite
	astore_7 
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	astore 8
	aload_0 
	iconst_0 
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	getstatic laneSpeed // LevelConfig
	iload_1 
	aaload 
	arraylength 
	iconst_1 
	isub 
	istore 9
	goto Label38
Label22:
	getstatic laneSpeed // LevelConfig
	iload_1 
	aaload 
	iload 9
	iaload 
	ifne Label37
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0 
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	dup_x1 
	iconst_1 
	iadd 
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	iload 9
	iastore 
Label37:
	iinc 9 -1
Label38:
	iload 9
	ifge Label22
	iconst_0 
	istore 10
	goto Label48
Label43:
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload 10
	iconst_0 
	iastore 
	iinc 10 1
Label48:
	iload 10
	bipush 30
	if_icmplt Label43
	getstatic treeDensity // LevelConfig
	iload_1 
	iaload 
	iconst_1 
	isub 
	istore 11
	goto_w Label201
Label58:
	aload_2 
	invokenonvirtual com.plazmic.rooster.Loading.increment // pc=1
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	irem 
	iaload 
	istore_3 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	irem 
	istore_5 
	bipush 15
	iload_3 
	imul 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 6
	irem 
	bipush 6
	isub 
	iadd 
	istore_4 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_3 
	iaload 
	bipush 10
	if_icmplt Label92
	goto_w Label200
Label92:
	iload_3 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	bipush 2
	isub 
	if_icmplt Label107
	iload_5 
	bipush 100
	if_icmple Label107
	iload_5 
	sipush 140
	if_icmpge Label107
	goto_w Label200
Label107:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_3 
	aaload 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_3 
	iaload 
	aaload 
	iload_5 
	iload_4 
	invokevirtual_short .virtual_8 // idx=8 pc=3
	iinc 6 1
	iload_6 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	arraylength 
	irem 
	istore_6 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_3 
	aaload 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_3 
	iaload 
	aaload 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_6 
	aaload 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_6 
	aaload 
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_6 
	aaload 
	invokevirtual getHeight( javax.microedition.lcdui.Image ) // pc=1
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Sprite.setImage // pc=5
	iload_6 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	arraylength 
	iconst_1 
	isub 
	if_icmpne Label162
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_3 
	aaload 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_3 
	iaload 
	aaload 
	bipush 9
	bipush 6
	bipush 11
	bipush 13
	invokenonvirtual com.plazmic.rooster.Sprite.defineCollisionRectangle // pc=5
	goto Label174
Label162:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_3 
	aaload 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_3 
	iaload 
	aaload 
	bipush 3
	bipush 3
	bipush 8
	bipush 8
	invokenonvirtual com.plazmic.rooster.Sprite.defineCollisionRectangle // pc=5
Label174:
	aload_7 
	iload_6 
	aaload 
	aload 8
	iload_6 
	dup2 
	iaload 
	dup_x2 
	iconst_1 
	iadd 
	iastore 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_3 
	aaload 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_3 
	iaload 
	aaload 
	aastore 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_3 
	dup2 
	iaload 
	iconst_1 
	iadd 
	iastore 
Label200:
	iinc 11 -1
Label201:
	iload 11
	iflt Label204
	goto_w Label58
Label204:
	bipush 2
	istore 12
	goto Label225
Label207:
	aload 8
	iload 12
	iaload 
	iconst_1 
	isub 
	istore 13
	goto Label222
Label214:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_7 
	iload 12
	aaload 
	iload 13
	aaload 
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	iinc 13 -1
Label222:
	iload 13
	ifge Label214
	iinc 12 -1
Label225:
	iload 12
	ifge Label207
	return 
	}


public final com.plazmic.rooster.LayerManager getTrees( com.plazmic.rooster.Forest ); // address: 0
	{
	areturn_field .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	}


public final reset( com.plazmic.rooster.Forest, int, com.plazmic.rooster.Loading, boolean ); // address: 0
	{
	enter 
	aload_0 
	iload_1 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	invokenonvirtual com.plazmic.rooster.LayerManager.clear // pc=1
	iload_1 
	ifeq Label20
	iload_3 
	ifne Label20
	getstatic obsticleImages // LevelConfig
	iload_1 
	iconst_1 
	isub 
	aaload 
	getstatic obsticleImages // LevelConfig
	iload_1 
	aaload 
	invokevirtual_short .equals // idx=1 pc=2
	ifne Label23
Label20:
	aload_0 
	iload_1 
	invokenonvirtual com.plazmic.rooster.Forest.setImages // pc=2
Label23:
	aload_0 
	iload_1 
	aload_2 
	invokenonvirtual com.plazmic.rooster.Forest.makeTrees // pc=3
	return 
	}


public final setImages( com.plazmic.rooster.Forest, int ); // address: 0
	{
	xenter 
	new_lib StringBuffer//java.lang.StringBuffer java.lang.StringBuffer java.lang.StringBuffer
	dup 
	ldc literal_32:"img/"
	invokespecial_lib java.lang.StringBuffer.<init> // pc=2
	getstatic obsticleImages // LevelConfig
	iload_1 
	aaload 
	invokevirtual append( java.lang.StringBuffer, java.lang.String ) // pc=2
	invokevirtual_short .toString // idx=2 pc=1
	invokestatic_lib createImage( java.lang.String ) // 
	astore_2 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_0 
	aload_2 
	iconst_0 
	iconst_0 
	bipush 15
	bipush 15
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	aastore 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_1 
	aload_2 
	bipush 15
	iconst_0 
	bipush 15
	bipush 15
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	aastore 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 2
	aload_2 
	iconst_0 
	bipush 15
	bipush 30
	bipush 30
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	aastore 
	return 
	astore_2 
	getstatic_lib out // System
	ldc literal_33:"Could not load one or more of the tree images."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}


public final boolean isCollision( com.plazmic.rooster.Forest, com.plazmic.rooster.Sprite ); // address: 0
	{
	enter 
	aload_1 
	invokevirtual_short .virtual_5 // idx=5 pc=1
	bipush 15
	idiv 
	istore_2 
	iload_2 
	istore_3 
	goto Label31
Label9:
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_3 
	iaload 
	iconst_1 
	isub 
	istore_4 
	goto Label28
Label16:
	aload_1 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_3 
	aaload 
	iload_4 
	aaload 
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Sprite.collidesWith // pc=3
	ifeq Label27
	iconst_1 
	ireturn 
Label27:
	iinc 4 -1
Label28:
	iload_4 
	ifge Label16
	iinc 3 1
Label31:
	iload_3 
	iload_2 
	iconst_1 
	iadd 
	if_icmple Label9
	iconst_0 
	ireturn 
	}

}
