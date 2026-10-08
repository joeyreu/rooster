// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 25
// ########################################################


package com.plazmic.rooster;


abstract final class Traffic extends Object

{
	// @@@@@@@@@@@@@ Static fields 
	private final static com.plazmic.rooster.LevelConfig /*com.plazmic.rooster.LevelConfig*/  field_53138 ; // ofs = 53138 addr = 93)

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.LayerManager /*com.plazmic.rooster.LayerManager*/  field_53094 ; // ofs = 53094 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image[]*/  field_53098 ; // ofs = 53098 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image[]*/  field_53102 ; // ofs = 53102 addr = 0)
	private java.util.Random /*java.util.Random*/  field_53106 ; // ofs = 53106 addr = 0)
	private com.plazmic.rooster.Vector /*com.plazmic.rooster.Vector[]*/  field_53110 ; // ofs = 53110 addr = 0)
	private com.plazmic.rooster.Vector /*com.plazmic.rooster.Vector*/  field_53114 ; // ofs = 53114 addr = 0)
	private int[] /*int[]*/  field_53118 ; // ofs = 53118 addr = 0)
	private int /*int*/  field_53122 ; // ofs = 53122 addr = 0)
	private int /*int*/  field_53126 ; // ofs = 53126 addr = 0)
	private int /*int*/  field_53130 ; // ofs = 53130 addr = 0)
	private int /*int*/  field_53134 ; // ofs = 53134 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.Traffic, int, int, int, com.plazmic.rooster.Loading ); // address: 0
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
	bipush 10
	newarray_object_lib javax.microedition.lcdui.Image//javax.microedition.lcdui.Image javax.microedition.lcdui.Image javax.microedition.lcdui.Image
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	bipush 10
	newarray_object_lib javax.microedition.lcdui.Image//javax.microedition.lcdui.Image javax.microedition.lcdui.Image javax.microedition.lcdui.Image
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	new_lib java.util.Random//java.util.Random java.util.Random java.util.Random
	dup 
	invokespecial_lib java.util.Random.<init> // pc=1
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	new Vector
	dup 
	bipush 70
	invokespecial com.plazmic.rooster.Vector.<init> // pc=2
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	bipush 30
	newarray 5
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0 
	iconst_1 
	putfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0 
	iload_2 
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0 
	iload_3 
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	aload_0 
	iload_1 
	putfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0 
	iload_1 
	invokenonvirtual com.plazmic.rooster.Traffic.setImages // pc=2
	aload_0 
	iconst_0 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_0 
	istore_5 
	goto Label68
Label52:
	getstatic laneSpeed // LevelConfig
	iload_1 
	aaload 
	iload_5 
	iaload 
	ifeq Label67
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	dup_x1 
	iconst_1 
	iadd 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iload_5 
	iastore 
Label67:
	iinc 5 1
Label68:
	iload_5 
	getstatic laneSpeed // LevelConfig
	iload_1 
	aaload 
	arraylength 
	if_icmplt Label52
	aload_0 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	newarray_object Vector
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iconst_0 
	istore_6 
	goto Label92
Label84:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_6 
	new Vector
	dup 
	bipush 11
	invokespecial com.plazmic.rooster.Vector.<init> // pc=2
	aastore 
	iinc 6 1
Label92:
	iload_6 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	if_icmplt Label84
	iconst_0 
	istore_7 
	iconst_0 
	istore 8
	goto Label155
Label103:
	aload_4 
	invokenonvirtual com.plazmic.rooster.Loading.increment // pc=1
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	new CarSprite
	dup 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload 8
	aaload 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	iload 8
	aaload 
	invokespecial com.plazmic.rooster.CarSprite.<init> // pc=3
	invokenonvirtual com.plazmic.rooster.Vector.addElement // pc=2
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_7 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_7 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	iconst_1 
	iconst_1 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload 8
	aaload 
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	bipush 3
	isub 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload 8
	aaload 
	invokevirtual getHeight( javax.microedition.lcdui.Image ) // pc=1
	bipush 7
	isub 
	invokenonvirtual com.plazmic.rooster.Sprite.defineCollisionRectangle // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_7 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	iinc 7 1
	iinc 8 1
	iload 8
	getstatic trafficBounds // LevelConfig
	iload_1 
	aaload 
	arraylength 
	iconst_1 
	isub 
	irem 
	istore 8
Label155:
	iload_7 
	bipush 70
	if_icmplt Label103
	iload_2 
	iconst_1 
	isub 
	istore 9
	goto Label167
Label163:
	aload_0 
	invokenonvirtual com.plazmic.rooster.Traffic.moveTraffic // pc=1
	pop 
	iinc 9 -1
Label167:
	iload 9
	ifge Label163
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	synch_static Traffic
	clinit_wait 
	new LevelConfig
	dup 
	invokespecial com.plazmic.rooster.LevelConfig.<init> // pc=1
	putstatic com.plazmic.rooster.Traffic.field_53138 // Traffic
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final int moveTraffic( com.plazmic.rooster.Traffic ); // address: 0
	{
	enter 
	iconst_0 
	istore_4 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 100
	irem 
	getstatic carDensity // LevelConfig
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iaload 
	if_icmplt Label13
	goto_w Label114
Label13:
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	invokenonvirtual com.plazmic.rooster.Vector.size // pc=1
	ifgt Label17
	goto_w Label114
Label17:
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	irem 
	istore_2 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	invokenonvirtual com.plazmic.rooster.Vector.firstElement // pc=1
	astore_1 
	aload_1 
	getstatic laneSpeed // LevelConfig
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aaload 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_2 
	iaload 
	iaload 
	invokenonvirtual com.plazmic.rooster.CarSprite.setSpeed // pc=2
	aload_1 
	getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	ifle Label42
	aload_1 
	bipush 2
	invokenonvirtual com.plazmic.rooster.Sprite.setTransform // pc=2
	goto Label45
Label42:
	aload_1 
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Sprite.setTransform // pc=2
Label45:
	aload_1 
	iconst_1 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_1 
	aload_1 
	getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	ifle Label56
	aload_1 
	invokevirtual_short .virtual_7 // idx=7 pc=1
	ineg 
	goto Label57
Label56:
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
Label57:
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_2 
	iaload 
	bipush 15
	imul 
	invokevirtual_short .virtual_8 // idx=8 pc=3
	iconst_0 
	istore_3 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_1 
	isub 
	istore_5 
	goto Label98
Label70:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_5 
	iaload 
	aaload 
	invokenonvirtual com.plazmic.rooster.Vector.size // pc=1
	iconst_1 
	isub 
	istore_6 
	goto Label95
Label80:
	aload_1 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_5 
	iaload 
	aaload 
	iload_6 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Sprite.collidesWith // pc=3
	ifeq Label94
	iconst_1 
	istore_3 
	goto Label97
Label94:
	iinc 6 -1
Label95:
	iload_6 
	ifge Label80
Label97:
	iinc 5 -1
Label98:
	iload_5 
	ifge Label70
	iload_3 
	ifne Label114
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_2 
	iaload 
	aaload 
	aload_1 
	invokenonvirtual com.plazmic.rooster.Vector.addElement // pc=2
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Vector.removeElementAt // pc=2
	iconst_1 
	istore_4 
Label114:
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_1 
	isub 
	istore_5 
	goto Label178
Label119:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_5 
	iaload 
	aaload 
	invokenonvirtual com.plazmic.rooster.Vector.size // pc=1
	iconst_1 
	isub 
	istore_6 
	goto Label175
Label129:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_5 
	iaload 
	aaload 
	iload_6 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	astore_1 
	aload_1 
	invokenonvirtual com.plazmic.rooster.CarSprite.move // pc=1
	aload_1 
	invokevirtual_short .virtual_4 // idx=4 pc=1
	aload_1 
	invokevirtual_short .virtual_7 // idx=7 pc=1
	iadd 
	ifge Label148
	aload_1 
	getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	iflt Label155
Label148:
	aload_1 
	invokevirtual_short .virtual_4 // idx=4 pc=1
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	if_icmple Label174
	aload_1 
	getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	ifle Label174
Label155:
	aload_1 
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_5 
	iaload 
	aaload 
	iload_6 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	invokenonvirtual com.plazmic.rooster.Vector.addElement // pc=2
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_5 
	iaload 
	aaload 
	iload_6 
	invokenonvirtual com.plazmic.rooster.Vector.removeElementAt // pc=2
Label174:
	iinc 6 -1
Label175:
	iload_6 
	ifge Label129
	iinc 5 -1
Label178:
	iload_5 
	ifge Label119
	iload_4 
	ireturn 
	}


public final com.plazmic.rooster.LayerManager getTraffic( com.plazmic.rooster.Traffic ); // address: 0
	{
	areturn_field .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	}


public final reset( com.plazmic.rooster.Traffic, int, com.plazmic.rooster.Loading, boolean ); // address: 0
	{
	enter 
	aload_0 
	iload_1 
	putfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_1 
	ifeq Label18
	iload_3 
	ifne Label18
	getstatic trafficImages // LevelConfig
	iload_1 
	iconst_1 
	isub 
	aaload 
	getstatic trafficImages // LevelConfig
	iload_1 
	aaload 
	invokevirtual_short .equals // idx=1 pc=2
	ifne Label21
Label18:
	aload_0 
	iload_1 
	invokenonvirtual com.plazmic.rooster.Traffic.setImages // pc=2
Label21:
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_1 
	isub 
	istore_4 
	goto Label64
Label26:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_4 
	iaload 
	aaload 
	invokenonvirtual com.plazmic.rooster.Vector.size // pc=1
	iconst_1 
	isub 
	istore_5 
	goto Label55
Label36:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_4 
	iaload 
	aaload 
	iload_5 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_4 
	iaload 
	aaload 
	iload_5 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	invokenonvirtual com.plazmic.rooster.Vector.addElement // pc=2
	iinc 5 -1
Label55:
	iload_5 
	ifge Label36
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iload_4 
	iaload 
	aaload 
	invokenonvirtual com.plazmic.rooster.Vector.removeAllElements // pc=1
	iinc 4 -1
Label64:
	iload_4 
	ifge Label26
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	invokenonvirtual com.plazmic.rooster.LayerManager.clear // pc=1
	iconst_0 
	istore_5 
	iconst_0 
	istore_6 
	goto Label119
Label73:
	aload_2 
	invokenonvirtual com.plazmic.rooster.Loading.increment // pc=1
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_5 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload_6 
	aaload 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	iload_6 
	aaload 
	invokenonvirtual com.plazmic.rooster.Sprite.setImage // pc=3
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_5 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	iconst_1 
	iconst_1 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload_6 
	aaload 
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	bipush 3
	isub 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload_6 
	aaload 
	invokevirtual getHeight( javax.microedition.lcdui.Image ) // pc=1
	bipush 7
	isub 
	invokenonvirtual com.plazmic.rooster.Sprite.defineCollisionRectangle // pc=5
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	iload_5 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	iinc 5 1
	iinc 6 1
	iload_6 
	getstatic trafficBounds // LevelConfig
	iload_1 
	aaload 
	arraylength 
	iconst_1 
	isub 
	irem 
	istore_6 
Label119:
	iload_5 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	invokenonvirtual com.plazmic.rooster.Vector.size // pc=1
	if_icmplt Label73
	aload_0 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	newarray_object Vector
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	iconst_1 
	isub 
	istore_7 
	goto Label146
Label138:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_7 
	new Vector
	dup 
	bipush 11
	invokespecial com.plazmic.rooster.Vector.<init> // pc=2
	aastore 
	iinc 7 -1
Label146:
	iload_7 
	ifge Label138
	aload_0 
	iconst_0 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	getstatic laneSpeed // LevelConfig
	iload_1 
	aaload 
	arraylength 
	iconst_1 
	isub 
	istore 8
	goto Label175
Label159:
	getstatic laneSpeed // LevelConfig
	iload_1 
	aaload 
	iload 8
	iaload 
	ifeq Label174
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	dup_x1 
	iconst_1 
	iadd 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iload 8
	iastore 
Label174:
	iinc 8 -1
Label175:
	iload 8
	ifge Label159
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_1 
	isub 
	istore 9
	goto Label186
Label182:
	aload_0 
	invokenonvirtual com.plazmic.rooster.Traffic.moveTraffic // pc=1
	pop 
	iinc 9 -1
Label186:
	iload 9
	ifge Label182
	return 
	}


public final setImages( com.plazmic.rooster.Traffic, int ); // address: 0
	{
	xenter 
	new_lib StringBuffer//java.lang.StringBuffer java.lang.StringBuffer java.lang.StringBuffer
	dup 
	ldc literal_32:"img/"
	invokespecial_lib java.lang.StringBuffer.<init> // pc=2
	getstatic trafficImages // LevelConfig
	iload_1 
	aaload 
	invokevirtual append( java.lang.StringBuffer, java.lang.String ) // pc=2
	invokevirtual_short .toString // idx=2 pc=1
	invokestatic_lib createImage( java.lang.String ) // 
	astore_2 
	iconst_0 
	istore_3 
	goto Label62
Label15:
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload_3 
	aload_2 
	getstatic trafficBounds // LevelConfig
	iload_1 
	aaload 
	iload_3 
	iaload 
	iconst_1 
	iadd 
	iconst_0 
	getstatic trafficBounds // LevelConfig
	iload_1 
	aaload 
	iload_3 
	iconst_1 
	iadd 
	iaload 
	getstatic trafficBounds // LevelConfig
	iload_1 
	aaload 
	iload_3 
	iaload 
	isub 
	bipush 18
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	aastore 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	iload_3 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload_3 
	aaload 
	iconst_0 
	iconst_0 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload_3 
	aaload 
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iload_3 
	aaload 
	invokevirtual getHeight( javax.microedition.lcdui.Image ) // pc=1
	bipush 2
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	aastore 
	iinc 3 1
Label62:
	iload_3 
	getstatic trafficBounds // LevelConfig
	iload_1 
	aaload 
	arraylength 
	iconst_1 
	isub 
	if_icmplt Label15
	return 
	astore_2 
	getstatic_lib out // System
	ldc literal_131:"Could not load one or more of the car images."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}


public final boolean isCollision( com.plazmic.rooster.Traffic, com.plazmic.rooster.Sprite ); // address: 0
	{
	enter 
	aload_1 
	invokevirtual_short .virtual_5 // idx=5 pc=1
	bipush 15
	idiv 
	istore_2 
	iload_2 
	istore_3 
	goto Label32
Label9:
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_3 
	aaload 
	invokenonvirtual com.plazmic.rooster.Vector.size // pc=1
	iconst_1 
	isub 
	istore_4 
	goto Label29
Label17:
	aload_1 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	iload_3 
	aaload 
	iload_4 
	invokenonvirtual com.plazmic.rooster.Vector.elementAt // pc=2
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Sprite.collidesWith // pc=3
	ifeq Label28
	iconst_1 
	ireturn 
Label28:
	iinc 4 -1
Label29:
	iload_4 
	ifge Label17
	iinc 3 1
Label32:
	iload_3 
	iload_2 
	iconst_1 
	iadd 
	if_icmple Label9
	iconst_0 
	ireturn 
	}

}
