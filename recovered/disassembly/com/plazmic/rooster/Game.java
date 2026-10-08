// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 6
// ########################################################


package com.plazmic.rooster;


abstract final class Game extends com.plazmic.rooster.Mode

{
	// @@@@@@@@@@@@@ Static fields 
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_50990 ; // ofs = 50990 addr = 22)
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_50996 ; // ofs = 50996 addr = 23)
	private final static com.plazmic.rooster.LevelConfig /*com.plazmic.rooster.LevelConfig*/  field_51002 ; // ofs = 51002 addr = 24)
	private final static int[] /*int[]*/  field_51008 ; // ofs = 51008 addr = 25)

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_50798 ; // ofs = 50798 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50802 ; // ofs = 50802 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50806 ; // ofs = 50806 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50810 ; // ofs = 50810 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50814 ; // ofs = 50814 addr = 0)
	private com.plazmic.rooster.Sprite /*com.plazmic.rooster.Sprite*/  field_50818 ; // ofs = 50818 addr = 0)
	private com.plazmic.rooster.Sprite /*com.plazmic.rooster.Sprite*/  field_50822 ; // ofs = 50822 addr = 0)
	private com.plazmic.rooster.Sprite /*com.plazmic.rooster.Sprite*/  field_50826 ; // ofs = 50826 addr = 0)
	private com.plazmic.rooster.Sprite /*com.plazmic.rooster.Sprite*/  field_50830 ; // ofs = 50830 addr = 0)
	private com.plazmic.rooster.Levels /*com.plazmic.rooster.Levels*/  field_50834 ; // ofs = 50834 addr = 0)
	private com.plazmic.rooster.Rooster /*com.plazmic.rooster.Rooster*/  field_50838 ; // ofs = 50838 addr = 0)
	private int /*int*/  field_50842 ; // ofs = 50842 addr = 0)
	private com.plazmic.rooster.Traffic /*com.plazmic.rooster.Traffic*/  field_50846 ; // ofs = 50846 addr = 0)
	private com.plazmic.rooster.Forest /*com.plazmic.rooster.Forest*/  field_50850 ; // ofs = 50850 addr = 0)
	public com.plazmic.rooster.HUD /*com.plazmic.rooster.HUD*/  hud ; // ofs = 50854 addr = 0)
	public boolean /*boolean*/  paused ; // ofs = 50858 addr = 0)
	private com.plazmic.rooster.LayerManager /*com.plazmic.rooster.LayerManager*/  field_50862 ; // ofs = 50862 addr = 0)
	private com.plazmic.rooster.LayerManager /*com.plazmic.rooster.LayerManager*/  field_50866 ; // ofs = 50866 addr = 0)
	private com.plazmic.rooster.LayerManager /*com.plazmic.rooster.LayerManager*/  field_50870 ; // ofs = 50870 addr = 0)
	private com.plazmic.rooster.LayerManager /*com.plazmic.rooster.LayerManager*/  field_50874 ; // ofs = 50874 addr = 0)
	private com.plazmic.rooster.LayerManager /*com.plazmic.rooster.LayerManager*/  field_50878 ; // ofs = 50878 addr = 0)
	private com.plazmic.rooster.LayerManager /*com.plazmic.rooster.LayerManager*/  field_50882 ; // ofs = 50882 addr = 0)
	private int /*int*/  field_50886 ; // ofs = 50886 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_50890 ; // ofs = 50890 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_50894 ; // ofs = 50894 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_50898 ; // ofs = 50898 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_50902 ; // ofs = 50902 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_50906 ; // ofs = 50906 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_50910 ; // ofs = 50910 addr = 0)
	private int /*int*/  field_50914 ; // ofs = 50914 addr = 0)
	private long /*long*/  field_50918 ; // ofs = 50918 addr = 0)
	private boolean /*boolean*/  field_50922 ; // ofs = 50922 addr = 0)
	private boolean /*boolean*/  field_50926 ; // ofs = 50926 addr = 0)
	private int /*int*/  field_50930 ; // ofs = 50930 addr = 0)
	private java.util.Random /*java.util.Random*/  field_50934 ; // ofs = 50934 addr = 0)
	private boolean /*boolean*/  field_50938 ; // ofs = 50938 addr = 0)
	private boolean /*boolean*/  field_50942 ; // ofs = 50942 addr = 0)
	private boolean /*boolean*/  field_50946 ; // ofs = 50946 addr = 0)
	private javax.microedition.lcdui.Display /*javax.microedition.lcdui.Display*/  field_50950 ; // ofs = 50950 addr = 0)
	private int /*int*/  field_50954 ; // ofs = 50954 addr = 0)
	private short /*short*/  field_50958 ; // ofs = 50958 addr = 0)
	private short /*short*/  field_50962 ; // ofs = 50962 addr = 0)
	private short /*short*/  field_50966 ; // ofs = 50966 addr = 0)
	private StringBuffer /*java.lang.StringBuffer*/  field_50970 ; // ofs = 50970 addr = 0)
	private long /*long*/  field_50974 ; // ofs = 50974 addr = 0)
	private int /*int*/  field_50978 ; // ofs = 50978 addr = 0)
	private StringBuffer /*java.lang.StringBuffer*/  field_50982 ; // ofs = 50982 addr = 0)
	private int /*int*/  field_50986 ; // ofs = 50986 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.Game, com.plazmic.rooster.RoosterCanvas, int, com.plazmic.rooster.Loading ); // address: 0
	{
	xenter 
	aload_0 
	invokespecial com.plazmic.rooster.Mode.<init> // pc=1
	aload_0 
	new HUD
	dup 
	invokespecial com.plazmic.rooster.HUD.<init> // pc=1
	putfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	aload_0 
	iconst_0 
	putfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	aload_0 
	new LayerManager
	dup 
	invokespecial com.plazmic.rooster.LayerManager.<init> // pc=1
	putfield .field_16_16   // get_name_1:  .field_16_16   // get_name_2:  .field_16_16   // get_Name:    .field_16_16   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 16
	aload_0 
	new LayerManager
	dup 
	invokespecial com.plazmic.rooster.LayerManager.<init> // pc=1
	putfield .field_19_19   // get_name_1:  .field_19_19   // get_name_2:  .field_19_19   // get_Name:    .field_19_19   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 19
	aload_0 
	new LayerManager
	dup 
	invokespecial com.plazmic.rooster.LayerManager.<init> // pc=1
	putfield .field_20_20   // get_name_1:  .field_20_20   // get_name_2:  .field_20_20   // get_Name:    .field_20_20   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 20
	aload_0 
	new LayerManager
	dup 
	invokespecial com.plazmic.rooster.LayerManager.<init> // pc=1
	putfield .field_21_21   // get_name_1:  .field_21_21   // get_name_2:  .field_21_21   // get_Name:    .field_21_21   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 21
	aload_0 
	bipush 2
	putfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	aload_0 
	iconst_0 
	putfield .field_32_32   // get_name_1:  .field_32_32   // get_name_2:  .field_32_32   // get_Name:    .field_32_32   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 32
	aload_0 
	iconst_0 
	putfield .field_33_33   // get_name_1:  .field_33_33   // get_name_2:  .field_33_33   // get_Name:    .field_33_33   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 33
	aload_0 
	bipush -1
	putfield .field_34_34   // get_name_1:  .field_34_34   // get_name_2:  .field_34_34   // get_Name:    .field_34_34   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 34
	aload_0 
	new_lib java.util.Random//java.util.Random java.util.Random java.util.Random
	dup 
	invokespecial_lib java.util.Random.<init> // pc=1
	putfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	aload_0 
	bipush 16
	putfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	aload_0 
	bipush 20
	putfield .field_41_41   // get_name_1:  .field_41_41   // get_name_2:  .field_41_41   // get_Name:    .field_41_41   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 41
	aload_0 
	bipush 20
	putfield .field_42_42   // get_name_1:  .field_42_42   // get_name_2:  .field_42_42   // get_Name:    .field_42_42   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 42
	aload_0 
	bipush 20
	putfield .field_43_43   // get_name_1:  .field_43_43   // get_name_2:  .field_43_43   // get_Name:    .field_43_43   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 43
	aload_0 
	new_lib StringBuffer//java.lang.StringBuffer java.lang.StringBuffer java.lang.StringBuffer
	dup 
	ldc literal_41:"Countdown +00"
	invokespecial_lib java.lang.StringBuffer.<init> // pc=2
	putfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	aload_0 
	iconst_0 
	i2l 
	lputfield .field_45_45   // get_name_1:  .field_45_45   // get_name_2:  .field_45_45   // get_Name:    .field_45_45   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 45
	aload_0 
	iconst_0 
	putfield .field_47_47   // get_name_1:  .field_47_47   // get_name_2:  .field_47_47   // get_Name:    .field_47_47   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 47
	aload_0 
	new_lib StringBuffer//java.lang.StringBuffer java.lang.StringBuffer java.lang.StringBuffer
	dup 
	ldc literal_42:"11"
	invokespecial_lib java.lang.StringBuffer.<init> // pc=2
	putfield .field_48_48   // get_name_1:  .field_48_48   // get_name_2:  .field_48_48   // get_Name:    .field_48_48   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 48
	aload_0 
	aload_1 
	getfield parent   // get_name_1:  parent   // get_name_2:  parent   // get_Name:    parent   // getName->1:  parent   // getName->2:  parent   // getName->N:  parent   // ofs = 52398 ord = 0 addr = 0
	invokestatic_lib getDisplay( javax.microedition.midlet.MIDlet ) // 
	putfield .field_39_39   // get_name_1:  .field_39_39   // get_name_2:  .field_39_39   // get_Name:    .field_39_39   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 39
	aload_0 
	iload_2 
	putfield .field_29_29   // get_name_1:  .field_29_29   // get_name_2:  .field_29_29   // get_Name:    .field_29_29   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 29
	aload_0 
	new Levels
	dup 
	iload_2 
	aload_3 
	invokespecial com.plazmic.rooster.Levels.<init> // pc=3
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_43:"Hide"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_27_27   // get_name_1:  .field_27_27   // get_name_2:  .field_27_27   // get_Name:    .field_27_27   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 27
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_44:"New Game"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_24_24   // get_name_1:  .field_24_24   // get_name_2:  .field_24_24   // get_Name:    .field_24_24   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 24
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_45:"Settings"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_25_25   // get_name_1:  .field_25_25   // get_name_2:  .field_25_25   // get_Name:    .field_25_25   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 25
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_46:"Quit Game"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_26_26   // get_name_1:  .field_26_26   // get_name_2:  .field_26_26   // get_Name:    .field_26_26   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 26
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_47:"Pause"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_23_23   // get_name_1:  .field_23_23   // get_name_2:  .field_23_23   // get_Name:    .field_23_23   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 23
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_48:"Close"
	bipush 7
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_28_28   // get_name_1:  .field_28_28   // get_name_2:  .field_28_28   // get_Name:    .field_28_28   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 28
	aload_3 
	invokenonvirtual com.plazmic.rooster.Loading.reset // pc=1
	aload_3 
	getstatic treeDensity // LevelConfig
	iload_2 
	iaload 
	bipush 70
	iadd 
	bipush 4
	iadd 
	getstatic levelDef // LevelConfig
	iload_2 
	aaload 
	arraylength 
	iadd 
	invokenonvirtual com.plazmic.rooster.Loading.setBarIncrements // pc=2
	aload_3 
	ldc literal_49:"Loading Images"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	ldc literal_50:"img/levelComplete_uLose_count.png"
	invokestatic_lib createImage( java.lang.String ) // 
	astore_4 
	aload_0 
	aload_4 
	iconst_0 
	iconst_0 
	sipush 179
	bipush 50
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	aload_4 
	iconst_0 
	bipush 50
	sipush 179
	bipush 25
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	aload_4 
	iconst_0 
	bipush 75
	sipush 179
	bipush 49
	iconst_0 
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	new_lib StringBuffer//java.lang.StringBuffer java.lang.StringBuffer java.lang.StringBuffer
	dup 
	ldc literal_32:"img/"
	invokespecial_lib java.lang.StringBuffer.<init> // pc=2
	getstatic deadRoosters // LevelConfig
	iload_2 
	aaload 
	invokevirtual append( java.lang.StringBuffer, java.lang.String ) // pc=2
	invokevirtual_short .toString // idx=2 pc=1
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	new Sprite
	dup 
	ldc literal_51:"img/cone_grey.png"
	invokestatic_lib createImage( java.lang.String ) // 
	bipush 15
	bipush 15
	iconst_0 
	invokespecial com.plazmic.rooster.Sprite.<init> // pc=5
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0_getfield .field_21_21   // get_name_1:  .field_21_21   // get_name_2:  .field_21_21   // get_Name:    .field_21_21   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 21
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	aload_0 
	new Sprite
	dup 
	ldc literal_52:"img/cone_purple.png"
	invokestatic_lib createImage( java.lang.String ) // 
	bipush 15
	bipush 15
	iconst_0 
	invokespecial com.plazmic.rooster.Sprite.<init> // pc=5
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0_getfield .field_21_21   // get_name_1:  .field_21_21   // get_name_2:  .field_21_21   // get_Name:    .field_21_21   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 21
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	aload_0 
	new Sprite
	dup 
	ldc literal_53:"img/cone_orange.png"
	invokestatic_lib createImage( java.lang.String ) // 
	bipush 15
	bipush 15
	iconst_0 
	invokespecial com.plazmic.rooster.Sprite.<init> // pc=5
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0_getfield .field_21_21   // get_name_1:  .field_21_21   // get_name_2:  .field_21_21   // get_Name:    .field_21_21   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 21
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	goto Label247
	astore_5 
	getstatic_lib out // System
	ldc literal_54:"Could not find one of the main images."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
Label247:
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 100
	irem 
	bipush 25
	if_icmpge Label283
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_1 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	sipush 240
	bipush 40
	isub 
	irem 
	bipush 20
	iadd 
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	getstatic levelDef // LevelConfig
	iload_2 
	aaload 
	arraylength 
	bipush 15
	imul 
	bipush 30
	isub 
	irem 
	bipush 15
	iadd 
	invokevirtual_short .virtual_8 // idx=8 pc=3
	goto Label286
Label283:
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
Label286:
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 100
	irem 
	bipush 30
	if_icmpge Label322
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_1 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	sipush 240
	bipush 40
	isub 
	irem 
	bipush 20
	iadd 
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	getstatic levelDef // LevelConfig
	iload_2 
	aaload 
	arraylength 
	bipush 15
	imul 
	bipush 30
	isub 
	irem 
	bipush 15
	iadd 
	invokevirtual_short .virtual_8 // idx=8 pc=3
	goto Label325
Label322:
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
Label325:
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 100
	irem 
	bipush 50
	if_icmpge Label383
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_1 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	sipush 240
	bipush 40
	isub 
	irem 
	bipush 20
	iadd 
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	getstatic levelDef // LevelConfig
	iload_2 
	aaload 
	arraylength 
	bipush 15
	imul 
	bipush 30
	isub 
	irem 
	bipush 15
	iadd 
	invokevirtual_short .virtual_8 // idx=8 pc=3
	aload_0 
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 11
	irem 
	bipush 10
	iadd 
	putfield .field_49_49   // get_name_1:  .field_49_49   // get_name_2:  .field_49_49   // get_Name:    .field_49_49   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 49
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	invokevirtual length( java.lang.StringBuffer ) // pc=1
	bipush 2
	isub 
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	invokevirtual length( java.lang.StringBuffer ) // pc=1
	invokevirtual delete( java.lang.StringBuffer, int, int ) // pc=3
	pop 
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	aload_0_getfield .field_49_49   // get_name_1:  .field_49_49   // get_name_2:  .field_49_49   // get_Name:    .field_49_49   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 49
	invokevirtual append( java.lang.StringBuffer, int ) // pc=2
	pop 
	goto Label386
Label383:
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
Label386:
	arrayinit [0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 5, 0, 0, 0, 6, 0, 0, 0, 7, 0, 0, 0, 8, 0, 0, 0]
	astore_5 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_5 
	invokenonvirtual com.plazmic.rooster.Sprite.setFrameSequence // pc=2
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_5 
	invokenonvirtual com.plazmic.rooster.Sprite.setFrameSequence // pc=2
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_5 
	invokenonvirtual com.plazmic.rooster.Sprite.setFrameSequence // pc=2
	aload_0 
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	invokenonvirtual com.plazmic.rooster.Levels.getLevel // pc=1
	invokevirtual_short .virtual_4 // idx=4 pc=1
	sipush 160
	isub 
	putfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	aload_3 
	ldc literal_37:"Loading Traffic"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	aload_0 
	new Traffic
	dup 
	iload_2 
	sipush 240
	sipush 160
	aload_3 
	invokespecial com.plazmic.rooster.Traffic.<init> // pc=5
	putfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	aload_0 
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	invokenonvirtual com.plazmic.rooster.Traffic.getTraffic // pc=1
	putfield .field_17_17   // get_name_1:  .field_17_17   // get_name_2:  .field_17_17   // get_Name:    .field_17_17   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 17
	aload_3 
	ldc literal_38:"Loading Obstacles"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	aload_0 
	new Forest
	dup 
	iload_2 
	sipush 240
	sipush 160
	aload_3 
	invokespecial com.plazmic.rooster.Forest.<init> // pc=5
	putfield .field_13_13   // get_name_1:  .field_13_13   // get_name_2:  .field_13_13   // get_Name:    .field_13_13   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 13
	aload_0 
	aload_0_getfield .field_13_13   // get_name_1:  .field_13_13   // get_name_2:  .field_13_13   // get_Name:    .field_13_13   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 13
	invokenonvirtual com.plazmic.rooster.Forest.getTrees // pc=1
	putfield .field_18_18   // get_name_1:  .field_18_18   // get_name_2:  .field_18_18   // get_Name:    .field_18_18   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 18
	aload_0_getfield .field_16_16   // get_name_1:  .field_16_16   // get_name_2:  .field_16_16   // get_Name:    .field_16_16   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 16
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	invokenonvirtual com.plazmic.rooster.Levels.getLevel // pc=1
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	aload_3 
	ldc literal_39:"Loading Rooster"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	aload_0 
	new Rooster
	dup 
	sipush 240
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	invokenonvirtual com.plazmic.rooster.Levels.getLevel // pc=1
	invokevirtual_short .virtual_4 // idx=4 pc=1
	iload_2 
	invokespecial com.plazmic.rooster.Rooster.<init> // pc=4
	putfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0_getfield .field_19_19   // get_name_1:  .field_19_19   // get_name_2:  .field_19_19   // get_Name:    .field_19_19   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 19
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	aload_0 
	aload_1 
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	aload_0_getfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	invokenonvirtual com.plazmic.rooster.HUD.setLives // pc=2
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	getstatic startCarsPassed // LevelConfig
	iload_2 
	iaload 
	invokenonvirtual com.plazmic.rooster.HUD.setCarCount // pc=2
	aload_0 
	iconst_0 
	putfield .field_36_36   // get_name_1:  .field_36_36   // get_name_2:  .field_36_36   // get_Name:    .field_36_36   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 36
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit Mode
	synch_static Game
	clinit_wait 
	iconst_0 
	iconst_1 
	bipush 16
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.Game.field_50990 // Game
	iconst_0 
	iconst_1 
	bipush 8
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.Game.field_50996 // Game
	new LevelConfig
	dup 
	invokespecial com.plazmic.rooster.LevelConfig.<init> // pc=1
	putstatic com.plazmic.rooster.Game.field_51002 // Game
	arrayinit [-16, 46, 120, 0, -16, 46, 120, 0, 16, 110, 88, 0, -16, 46, 120, 0, -16, 46, 8, 0, -112, -82, 24, 0, -16, 46, 120, 0, -16, -126, 122, 0, 16, -18, -8, 0, -16, 46, -8, 0, -16, 37, -72, 0, -16, 126, -121, 0, -1, 46, 127, 0, -16, 46, 120, 0, -16, 46, 120, 0, -16, 52, 114, 0, -16, 78, 120, 0, 16, -98, 56, 0, 32, 46, 56, 0, 46, 35, 8, 0]
	putstatic com.plazmic.rooster.Game.field_51008 // Game
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final enablePsychoMode( com.plazmic.rooster.Game, boolean ); // address: 0
	{
	putfield_return .field_38_38   // get_name_1:  .field_38_38   // get_name_2:  .field_38_38   // get_Name:    .field_38_38   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 38
	}


public final enableFPSDisplay( com.plazmic.rooster.Game, boolean ); // address: 0
	{
	putfield_return .field_37_37   // get_name_1:  .field_37_37   // get_name_2:  .field_37_37   // get_Name:    .field_37_37   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 37
	}


public final reset( com.plazmic.rooster.Game, int, com.plazmic.rooster.Loading, boolean ); // address: 0
	{
	xenter 
	aload_2 
	invokenonvirtual com.plazmic.rooster.Loading.reset // pc=1
	aload_2 
	getstatic treeDensity // LevelConfig
	iload_1 
	iaload 
	bipush 70
	iadd 
	bipush 4
	iadd 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	iadd 
	invokenonvirtual com.plazmic.rooster.Loading.setBarIncrements // pc=2
	aload_0 
	iload_1 
	putfield .field_29_29   // get_name_1:  .field_29_29   // get_name_2:  .field_29_29   // get_Name:    .field_29_29   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 29
	aload_0 
	iconst_0 
	putfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	aload_2 
	ldc literal_36:"Loading Background"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	iload_1 
	aload_2 
	iload_3 
	invokenonvirtual com.plazmic.rooster.Levels.reset // pc=4
	aload_0 
	iconst_0 
	putfield .field_34_34   // get_name_1:  .field_34_34   // get_name_2:  .field_34_34   // get_Name:    .field_34_34   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 34
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	bipush 2
	invokenonvirtual com.plazmic.rooster.Rooster.setSpeed // pc=2
	iload_1 
	ifeq Label41
	iload_3 
	ifeq Label49
Label41:
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.resetScore // pc=1
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	bipush 2
	invokenonvirtual com.plazmic.rooster.HUD.setLives // pc=2
	aload_0 
	bipush 2
	putfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
Label49:
	aload_0 
	iconst_0 
	putfield .field_32_32   // get_name_1:  .field_32_32   // get_name_2:  .field_32_32   // get_Name:    .field_32_32   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 32
	aload_0 
	iconst_0 
	putfield .field_33_33   // get_name_1:  .field_33_33   // get_name_2:  .field_33_33   // get_Name:    .field_33_33   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 33
	aload_0_getfield .field_16_16   // get_name_1:  .field_16_16   // get_name_2:  .field_16_16   // get_Name:    .field_16_16   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 16
	invokenonvirtual com.plazmic.rooster.LayerManager.clear // pc=1
	aload_0_getfield .field_16_16   // get_name_1:  .field_16_16   // get_name_2:  .field_16_16   // get_Name:    .field_16_16   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 16
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	invokenonvirtual com.plazmic.rooster.Levels.getLevel // pc=1
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	aload_2 
	ldc literal_37:"Loading Traffic"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	iload_1 
	aload_2 
	iload_3 
	invokenonvirtual com.plazmic.rooster.Traffic.reset // pc=4
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	getstatic startCarsPassed // LevelConfig
	iload_1 
	iaload 
	invokenonvirtual com.plazmic.rooster.HUD.setCarCount // pc=2
	aload_0 
	iconst_0 
	putfield .field_36_36   // get_name_1:  .field_36_36   // get_name_2:  .field_36_36   // get_Name:    .field_36_36   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 36
	aload_0 
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	invokenonvirtual com.plazmic.rooster.Levels.getLevel // pc=1
	invokevirtual_short .virtual_4 // idx=4 pc=1
	aload_0 
	pop 
	sipush 160
	isub 
	putfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	aload_0_getfield .field_20_20   // get_name_1:  .field_20_20   // get_name_2:  .field_20_20   // get_Name:    .field_20_20   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 20
	invokenonvirtual com.plazmic.rooster.LayerManager.clear // pc=1
	aload_2 
	ldc literal_38:"Loading Obstacles"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	aload_0_getfield .field_13_13   // get_name_1:  .field_13_13   // get_name_2:  .field_13_13   // get_Name:    .field_13_13   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 13
	iload_1 
	aload_2 
	iload_3 
	invokenonvirtual com.plazmic.rooster.Forest.reset // pc=4
	aload_0 
	bipush 16
	putfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	aload_2 
	ldc literal_39:"Loading Rooster"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	aload_0 
	pop 
	sipush 240
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	invokenonvirtual com.plazmic.rooster.Levels.getLevel // pc=1
	invokevirtual_short .virtual_4 // idx=4 pc=1
	invokenonvirtual com.plazmic.rooster.Rooster.setArea // pc=3
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.reset // pc=1
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_1 
	invokenonvirtual com.plazmic.rooster.Rooster.setImage // pc=2
	aload_0 
	bipush 20
	putfield .field_41_41   // get_name_1:  .field_41_41   // get_name_2:  .field_41_41   // get_Name:    .field_41_41   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 41
	aload_0 
	bipush 20
	putfield .field_42_42   // get_name_1:  .field_42_42   // get_name_2:  .field_42_42   // get_Name:    .field_42_42   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 42
	aload_0 
	bipush 20
	putfield .field_43_43   // get_name_1:  .field_43_43   // get_name_2:  .field_43_43   // get_Name:    .field_43_43   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 43
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 100
	irem 
	bipush 25
	if_icmpge Label162
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_1 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	aload_0 
	pop 
	sipush 240
	bipush 40
	isub 
	irem 
	bipush 20
	iadd 
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	bipush 15
	imul 
	bipush 30
	isub 
	irem 
	bipush 15
	iadd 
	invokevirtual_short .virtual_8 // idx=8 pc=3
	goto Label165
Label162:
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
Label165:
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 100
	irem 
	bipush 30
	if_icmpge Label203
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_1 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	aload_0 
	pop 
	sipush 240
	bipush 40
	isub 
	irem 
	bipush 20
	iadd 
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	bipush 15
	imul 
	bipush 30
	isub 
	irem 
	bipush 15
	iadd 
	invokevirtual_short .virtual_8 // idx=8 pc=3
	goto Label206
Label203:
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
Label206:
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 100
	irem 
	bipush 50
	if_icmpge Label266
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_1 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	aload_0 
	pop 
	sipush 240
	bipush 40
	isub 
	irem 
	bipush 20
	iadd 
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	getstatic levelDef // LevelConfig
	iload_1 
	aaload 
	arraylength 
	bipush 15
	imul 
	bipush 30
	isub 
	irem 
	bipush 15
	iadd 
	invokevirtual_short .virtual_8 // idx=8 pc=3
	aload_0 
	aload_0_getfield .field_35_35   // get_name_1:  .field_35_35   // get_name_2:  .field_35_35   // get_Name:    .field_35_35   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 35
	invokevirtual nextInt( java.util.Random ) // pc=1
	invokestatic_lib abs( int ) // 
	bipush 11
	irem 
	bipush 10
	iadd 
	putfield .field_49_49   // get_name_1:  .field_49_49   // get_name_2:  .field_49_49   // get_Name:    .field_49_49   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 49
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	invokevirtual length( java.lang.StringBuffer ) // pc=1
	bipush 2
	isub 
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	invokevirtual length( java.lang.StringBuffer ) // pc=1
	invokevirtual delete( java.lang.StringBuffer, int, int ) // pc=3
	pop 
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	aload_0_getfield .field_49_49   // get_name_1:  .field_49_49   // get_name_2:  .field_49_49   // get_Name:    .field_49_49   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 49
	invokevirtual append( java.lang.StringBuffer, int ) // pc=2
	pop 
	goto Label269
Label266:
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
Label269:
	aload_0 
	new_lib StringBuffer//java.lang.StringBuffer java.lang.StringBuffer java.lang.StringBuffer
	dup 
	ldc literal_32:"img/"
	invokespecial_lib java.lang.StringBuffer.<init> // pc=2
	getstatic deadRoosters // LevelConfig
	iload_1 
	aaload 
	invokevirtual append( java.lang.StringBuffer, java.lang.String ) // pc=2
	invokevirtual_short .toString // idx=2 pc=1
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	return 
	astore_4 
	getstatic_lib out // System
	ldc literal_40:"Could not find one of the dead images."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final render( com.plazmic.rooster.Game, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	iconst_0 
	istore_2 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	invokevirtual isShown( javax.microedition.lcdui.Displayable ) // pc=1
	ifne Label7
	goto_w Label595
Label7:
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	ifeq Label32
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	invokenonvirtual com.plazmic.rooster.Sprite.nextFrame // pc=1
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Sprite.collidesWith // pc=3
	ifeq Label32
	aload_0 
	aload_0_getfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	iconst_1 
	iadd 
	putfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	aload_0_getfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	invokenonvirtual com.plazmic.rooster.HUD.setLives // pc=2
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0 
	iconst_0 
	putfield .field_41_41   // get_name_1:  .field_41_41   // get_name_2:  .field_41_41   // get_Name:    .field_41_41   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 41
Label32:
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	ifeq Label55
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	invokenonvirtual com.plazmic.rooster.Sprite.nextFrame // pc=1
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Sprite.collidesWith // pc=3
	ifeq Label55
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.getCarCount // pc=1
	aload_0_getfield .field_49_49   // get_name_1:  .field_49_49   // get_name_2:  .field_49_49   // get_Name:    .field_49_49   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 49
	iadd 
	invokenonvirtual com.plazmic.rooster.HUD.setCarCount // pc=2
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0 
	iconst_0 
	putfield .field_42_42   // get_name_1:  .field_42_42   // get_name_2:  .field_42_42   // get_Name:    .field_42_42   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 42
Label55:
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	ifeq Label75
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	invokenonvirtual com.plazmic.rooster.Sprite.nextFrame // pc=1
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Sprite.collidesWith // pc=3
	ifeq Label75
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	bipush 4
	invokenonvirtual com.plazmic.rooster.Rooster.setSpeed // pc=2
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_0 
	invokevirtual_short .virtual_9 // idx=9 pc=2
	aload_0 
	iconst_0 
	putfield .field_43_43   // get_name_1:  .field_43_43   // get_name_2:  .field_43_43   // get_Name:    .field_43_43   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 43
Label75:
	aload_0_getfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	ifne Label105
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokenonvirtual com.plazmic.rooster.Sprite.getVisible // pc=1
	ifeq Label84
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	getstatic charMapping // Storage
	invokenonvirtual com.plazmic.rooster.Rooster.update // pc=2
Label84:
	aload_0_getfield .field_13_13   // get_name_1:  .field_13_13   // get_name_2:  .field_13_13   // get_Name:    .field_13_13   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 13
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokenonvirtual com.plazmic.rooster.Forest.isCollision // pc=2
	ifeq Label92
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	getstatic charMapping // Storage
	invokenonvirtual com.plazmic.rooster.Rooster.unUpdate // pc=2
Label92:
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	invokenonvirtual com.plazmic.rooster.Traffic.moveTraffic // pc=1
	istore_2 
	aload_0_getfield .field_32_32   // get_name_1:  .field_32_32   // get_name_2:  .field_32_32   // get_Name:    .field_32_32   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 32
	ifne Label105
	aload_0_getfield .field_33_33   // get_name_1:  .field_33_33   // get_name_2:  .field_33_33   // get_Name:    .field_33_33   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 33
	ifne Label105
	aload_0_getfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	bipush 15
	if_icmple Label105
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	iload_2 
	invokenonvirtual com.plazmic.rooster.HUD.decrementCarCount // pc=2
Label105:
	aload_0_getfield .field_12_12   // get_name_1:  .field_12_12   // get_name_2:  .field_12_12   // get_Name:    .field_12_12   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 12
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokenonvirtual com.plazmic.rooster.Traffic.isCollision // pc=2
	ifne Label113
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.getCarCount // pc=1
	ifne Label167
Label113:
	aload_0_getfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	bipush 16
	if_icmpne Label167
	getstatic isDeathBuzzOn // KeyMapper
	ifeq Label122
	aload_0_getfield .field_39_39   // get_name_1:  .field_39_39   // get_name_2:  .field_39_39   // get_Name:    .field_39_39   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 39
	sipush 500
	invokevirtual vibrate( javax.microedition.lcdui.Display, int ) // pc=2
	pop 
Label122:
	aload_0 
	new Sprite
	dup 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iconst_0 
	invokespecial com.plazmic.rooster.Sprite.<init> // pc=3
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokevirtual_short .virtual_4 // idx=4 pc=1
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokevirtual_short .virtual_5 // idx=5 pc=1
	invokevirtual_short .virtual_8 // idx=8 pc=3
	aload_0_getfield .field_20_20   // get_name_1:  .field_20_20   // get_name_2:  .field_20_20   // get_Name:    .field_20_20   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 20
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	invokenonvirtual com.plazmic.rooster.LayerManager.append // pc=2
	aload_0 
	aload_0_getfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	iconst_1 
	isub 
	putfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Rooster.setVisible // pc=2
	aload_0 
	iconst_0 
	putfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	aload_0_getfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	iflt Label156
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	aload_0_getfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	invokenonvirtual com.plazmic.rooster.HUD.setLives // pc=2
Label156:
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.getCarCount // pc=1
	ifne Label162
	aload_0 
	iconst_1 
	putfield .field_36_36   // get_name_1:  .field_36_36   // get_name_2:  .field_36_36   // get_Name:    .field_36_36   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 36
Label162:
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	getstatic startCarsPassed // LevelConfig
	aload_0_getfield .field_29_29   // get_name_1:  .field_29_29   // get_name_2:  .field_29_29   // get_Name:    .field_29_29   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 29
	iaload 
	invokenonvirtual com.plazmic.rooster.HUD.setCarCount // pc=2
Label167:
	aload_0_getfield .field_33_33   // get_name_1:  .field_33_33   // get_name_2:  .field_33_33   // get_Name:    .field_33_33   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 33
	ifeq Label170
	goto_w Label251
Label170:
	aload_0_getfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	bipush 15
	if_icmpge Label179
	aload_0 
	aload_0_getfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	iconst_1 
	iadd 
	putfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	goto_w Label251
Label179:
	aload_0_getfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	bipush 15
	if_icmpne Label217
	aload_0 
	aload_0_getfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	bipush 4
	iadd 
	putfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	aload_0_getfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	invokenonvirtual com.plazmic.rooster.Levels.getLevel // pc=1
	invokevirtual_short .virtual_4 // idx=4 pc=1
	aload_0 
	pop 
	sipush 160
	isub 
	if_icmplt Label251
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.reset // pc=1
	aload_0 
	bipush 16
	putfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	aload_0 
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	invokenonvirtual com.plazmic.rooster.Levels.getLevel // pc=1
	invokevirtual_short .virtual_4 // idx=4 pc=1
	aload_0 
	pop 
	sipush 160
	isub 
	putfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	aload_0 
	iconst_0 
	putfield .field_36_36   // get_name_1:  .field_36_36   // get_name_2:  .field_36_36   // get_Name:    .field_36_36   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 36
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	bipush 2
	invokenonvirtual com.plazmic.rooster.Rooster.setSpeed // pc=2
	goto Label251
Label217:
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokevirtual_short .virtual_5 // idx=5 pc=1
	aload_0 
	pop 
	sipush 160
	bipush 2
	idiv 
	isub 
	ifle Label251
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokevirtual_short .virtual_5 // idx=5 pc=1
	aload_0 
	pop 
	sipush 160
	bipush 2
	idiv 
	iadd 
	aload_0_getfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	invokenonvirtual com.plazmic.rooster.Levels.getLevel // pc=1
	invokevirtual_short .virtual_4 // idx=4 pc=1
	if_icmpge Label251
	aload_0 
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokevirtual_short .virtual_5 // idx=5 pc=1
	aload_0 
	pop 
	sipush 160
	bipush 2
	idiv 
	isub 
	putfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
Label251:
	aload_0_getfield .field_32_32   // get_name_1:  .field_32_32   // get_name_2:  .field_32_32   // get_Name:    .field_32_32   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 32
	ifne Label268
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.Rooster.getSprite // pc=1
	invokevirtual_short .virtual_5 // idx=5 pc=1
	ifgt Label268
	aload_0 
	iconst_1 
	putfield .field_32_32   // get_name_1:  .field_32_32   // get_name_2:  .field_32_32   // get_Name:    .field_32_32   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 32
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	bipush -1
	getstatic charMapping // Storage
	invokenonvirtual com.plazmic.rooster.Rooster.move // pc=3
	aload_0 
	invokestatic_lib currentTimeMillis(  ) // 
	lputfield .field_30_30   // get_name_1:  .field_30_30   // get_name_2:  .field_30_30   // get_Name:    .field_30_30   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 30
	goto_w Label332
Label268:
	aload_0_getfield .field_33_33   // get_name_1:  .field_33_33   // get_name_2:  .field_33_33   // get_Name:    .field_33_33   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 33
	ifne Label284
	aload_0_getfield .field_22_22   // get_name_1:  .field_22_22   // get_name_2:  .field_22_22   // get_Name:    .field_22_22   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 22
	bipush -1
	if_icmpne Label284
	aload_0 
	iconst_1 
	putfield .field_33_33   // get_name_1:  .field_33_33   // get_name_2:  .field_33_33   // get_Name:    .field_33_33   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 33
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	bipush -1
	getstatic charMapping // Storage
	invokenonvirtual com.plazmic.rooster.Rooster.move // pc=3
	aload_0 
	invokestatic_lib currentTimeMillis(  ) // 
	lputfield .field_30_30   // get_name_1:  .field_30_30   // get_name_2:  .field_30_30   // get_Name:    .field_30_30   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 30
	goto Label332
Label284:
	aload_0_getfield .field_32_32   // get_name_1:  .field_32_32   // get_name_2:  .field_32_32   // get_Name:    .field_32_32   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 32
	ifeq Label302
	invokestatic_lib currentTimeMillis(  ) // 
	aload_0 
	lgetfield .field_30_30   // get_name_1:  .field_30_30   // get_name_2:  .field_30_30   // get_Name:    .field_30_30   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 30
	lsub 
	sipush 3000
	i2l 
	lcmp 
	ifle Label302
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.getCarCount // pc=1
	invokenonvirtual com.plazmic.rooster.HUD.addToScore // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	bipush 5
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	goto Label332
Label302:
	aload_0_getfield .field_33_33   // get_name_1:  .field_33_33   // get_name_2:  .field_33_33   // get_Name:    .field_33_33   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 33
	ifeq Label332
	invokestatic_lib currentTimeMillis(  ) // 
	aload_0 
	lgetfield .field_30_30   // get_name_1:  .field_30_30   // get_name_2:  .field_30_30   // get_Name:    .field_30_30   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 30
	lsub 
	sipush 3000
	i2l 
	lcmp 
	ifle Label332
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.getScore // pc=1
	invokestatic int isInTopTen( int ) // Storage
	istore_3 
	iload_3 
	bipush -1
	if_icmple Label329
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield enterName   // get_name_1:  enterName   // get_name_2:  enterName   // get_Name:    enterName   // getName->1:  enterName   // getName->2:  enterName   // getName->N:  enterName   // ofs = 52434 ord = 9 addr = 0
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.getScore // pc=1
	iload_3 
	invokenonvirtual com.plazmic.rooster.EnterName.setHighScoreInfo // pc=3
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	bipush 2
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	goto Label332
Label329:
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	iconst_0 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
Label332:
	aload_0_getfield .field_38_38   // get_name_1:  .field_38_38   // get_name_2:  .field_38_38   // get_Name:    .field_38_38   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 38
	ifne Label339
	aload_0_getfield .field_16_16   // get_name_1:  .field_16_16   // get_name_2:  .field_16_16   // get_Name:    .field_16_16   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 16
	aload_1 
	iconst_0 
	aload_0_getfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	invokenonvirtual com.plazmic.rooster.LayerManager.paint // pc=4
Label339:
	getstatic drawAbove // LevelConfig
	aload_0_getfield .field_29_29   // get_name_1:  .field_29_29   // get_name_2:  .field_29_29   // get_Name:    .field_29_29   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 29
	baload 
	ifne Label348
	aload_0_getfield .field_18_18   // get_name_1:  .field_18_18   // get_name_2:  .field_18_18   // get_Name:    .field_18_18   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 18
	aload_1 
	iconst_0 
	aload_0_getfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	invokenonvirtual com.plazmic.rooster.LayerManager.paint // pc=4
Label348:
	aload_0_getfield .field_20_20   // get_name_1:  .field_20_20   // get_name_2:  .field_20_20   // get_Name:    .field_20_20   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 20
	aload_1 
	iconst_0 
	aload_0_getfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	invokenonvirtual com.plazmic.rooster.LayerManager.paint // pc=4
	aload_0_getfield .field_21_21   // get_name_1:  .field_21_21   // get_name_2:  .field_21_21   // get_Name:    .field_21_21   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 21
	aload_1 
	iconst_0 
	aload_0_getfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	invokenonvirtual com.plazmic.rooster.LayerManager.paint // pc=4
	aload_0_getfield .field_19_19   // get_name_1:  .field_19_19   // get_name_2:  .field_19_19   // get_Name:    .field_19_19   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 19
	aload_1 
	iconst_0 
	aload_0_getfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	invokenonvirtual com.plazmic.rooster.LayerManager.paint // pc=4
	aload_0_getfield .field_17_17   // get_name_1:  .field_17_17   // get_name_2:  .field_17_17   // get_Name:    .field_17_17   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 17
	aload_1 
	iconst_0 
	aload_0_getfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	invokenonvirtual com.plazmic.rooster.LayerManager.paint // pc=4
	getstatic drawAbove // LevelConfig
	aload_0_getfield .field_29_29   // get_name_1:  .field_29_29   // get_name_2:  .field_29_29   // get_Name:    .field_29_29   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 29
	baload 
	ifeq Label377
	aload_0_getfield .field_18_18   // get_name_1:  .field_18_18   // get_name_2:  .field_18_18   // get_Name:    .field_18_18   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 18
	aload_1 
	iconst_0 
	aload_0_getfield .field_11_11   // get_name_1:  .field_11_11   // get_name_2:  .field_11_11   // get_Name:    .field_11_11   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 11
	invokenonvirtual com.plazmic.rooster.LayerManager.paint // pc=4
Label377:
	aload_0_getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	aload_1 
	aload_0_getfield .field_29_29   // get_name_1:  .field_29_29   // get_name_2:  .field_29_29   // get_Name:    .field_29_29   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 29
	invokenonvirtual com.plazmic.rooster.HUD.paint // pc=3
	aload_0_getfield .field_32_32   // get_name_1:  .field_32_32   // get_name_2:  .field_32_32   // get_Name:    .field_32_32   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 32
	ifeq Label390
	aload_1 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	bipush 120
	bipush 80
	bipush 3
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	goto_w Label551
Label390:
	aload_0_getfield .field_33_33   // get_name_1:  .field_33_33   // get_name_2:  .field_33_33   // get_Name:    .field_33_33   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 33
	ifeq Label399
	aload_1 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	bipush 120
	bipush 80
	bipush 3
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	goto_w Label551
Label399:
	aload_0_getfield .field_36_36   // get_name_1:  .field_36_36   // get_name_2:  .field_36_36   // get_Name:    .field_36_36   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 36
	ifeq Label408
	aload_1 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	bipush 120
	bipush 80
	bipush 3
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	goto_w Label551
Label408:
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	ifeq Label414
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	invokenonvirtual com.plazmic.rooster.Sprite.nextFrame // pc=1
	goto Label455
Label414:
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	ifne Label455
	aload_0_getfield .field_41_41   // get_name_1:  .field_41_41   // get_name_2:  .field_41_41   // get_Name:    .field_41_41   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 41
	bipush 20
	if_icmpge Label455
	aload_0 
	aload_0_getfield .field_41_41   // get_name_1:  .field_41_41   // get_name_2:  .field_41_41   // get_Name:    .field_41_41   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 41
	iconst_1 
	iadd 
	i2s 
	putfield .field_41_41   // get_name_1:  .field_41_41   // get_name_2:  .field_41_41   // get_Name:    .field_41_41   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 41
	aload_1 
	iconst_0 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	getstatic com.plazmic.rooster.Game.field_50990 // Game
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	ldc literal_34:"Free Bird"
	bipush 121
	bipush 81
	aload_0_getfield .field_41_41   // get_name_1:  .field_41_41   // get_name_2:  .field_41_41   // get_Name:    .field_41_41   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 41
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	getstatic com.plazmic.rooster.Game.field_51008 // Game
	aload_0_getfield .field_41_41   // get_name_1:  .field_41_41   // get_name_2:  .field_41_41   // get_Name:    .field_41_41   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 41
	iconst_1 
	isub 
	iaload 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	ldc literal_34:"Free Bird"
	bipush 120
	bipush 80
	aload_0_getfield .field_41_41   // get_name_1:  .field_41_41   // get_name_2:  .field_41_41   // get_Name:    .field_41_41   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 41
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
Label455:
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	ifeq Label461
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	invokenonvirtual com.plazmic.rooster.Sprite.nextFrame // pc=1
	goto Label504
Label461:
	aload_0_getfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	ifne Label504
	aload_0_getfield .field_42_42   // get_name_1:  .field_42_42   // get_name_2:  .field_42_42   // get_Name:    .field_42_42   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 42
	bipush 20
	if_icmpge Label504
	aload_0 
	aload_0_getfield .field_42_42   // get_name_1:  .field_42_42   // get_name_2:  .field_42_42   // get_Name:    .field_42_42   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 42
	iconst_1 
	iadd 
	i2s 
	putfield .field_42_42   // get_name_1:  .field_42_42   // get_name_2:  .field_42_42   // get_Name:    .field_42_42   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 42
	aload_1 
	iconst_0 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	getstatic com.plazmic.rooster.Game.field_50990 // Game
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	invokevirtual_short .toString // idx=2 pc=1
	bipush 121
	bipush 81
	aload_0_getfield .field_42_42   // get_name_1:  .field_42_42   // get_name_2:  .field_42_42   // get_Name:    .field_42_42   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 42
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	getstatic com.plazmic.rooster.Game.field_51008 // Game
	aload_0_getfield .field_42_42   // get_name_1:  .field_42_42   // get_name_2:  .field_42_42   // get_Name:    .field_42_42   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 42
	iconst_1 
	isub 
	iaload 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	aload_0_getfield .field_44_44   // get_name_1:  .field_44_44   // get_name_2:  .field_44_44   // get_Name:    .field_44_44   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 44
	invokevirtual_short .toString // idx=2 pc=1
	bipush 120
	bipush 80
	aload_0_getfield .field_42_42   // get_name_1:  .field_42_42   // get_name_2:  .field_42_42   // get_Name:    .field_42_42   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 42
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
Label504:
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	ifeq Label510
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	invokenonvirtual com.plazmic.rooster.Sprite.nextFrame // pc=1
	goto Label551
Label510:
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	ifne Label551
	aload_0_getfield .field_43_43   // get_name_1:  .field_43_43   // get_name_2:  .field_43_43   // get_Name:    .field_43_43   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 43
	bipush 20
	if_icmpge Label551
	aload_0 
	aload_0_getfield .field_43_43   // get_name_1:  .field_43_43   // get_name_2:  .field_43_43   // get_Name:    .field_43_43   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 43
	iconst_1 
	iadd 
	i2s 
	putfield .field_43_43   // get_name_1:  .field_43_43   // get_name_2:  .field_43_43   // get_Name:    .field_43_43   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 43
	aload_1 
	iconst_0 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	getstatic com.plazmic.rooster.Game.field_50990 // Game
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	ldc literal_35:"Speed x2"
	bipush 121
	bipush 81
	aload_0_getfield .field_43_43   // get_name_1:  .field_43_43   // get_name_2:  .field_43_43   // get_Name:    .field_43_43   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 43
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	getstatic com.plazmic.rooster.Game.field_51008 // Game
	aload_0_getfield .field_43_43   // get_name_1:  .field_43_43   // get_name_2:  .field_43_43   // get_Name:    .field_43_43   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 43
	iconst_1 
	isub 
	iaload 
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	ldc literal_35:"Speed x2"
	bipush 120
	bipush 80
	aload_0_getfield .field_43_43   // get_name_1:  .field_43_43   // get_name_2:  .field_43_43   // get_Name:    .field_43_43   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 43
	isub 
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
Label551:
	aload_0_getfield .field_37_37   // get_name_1:  .field_37_37   // get_name_2:  .field_37_37   // get_Name:    .field_37_37   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 37
	ifeq Label595
	aload_0 
	aload_0_getfield .field_47_47   // get_name_1:  .field_47_47   // get_name_2:  .field_47_47   // get_Name:    .field_47_47   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 47
	iconst_1 
	iadd 
	putfield .field_47_47   // get_name_1:  .field_47_47   // get_name_2:  .field_47_47   // get_Name:    .field_47_47   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 47
	invokestatic_lib currentTimeMillis(  ) // 
	aload_0 
	lgetfield .field_45_45   // get_name_1:  .field_45_45   // get_name_2:  .field_45_45   // get_Name:    .field_45_45   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 45
	lsub 
	sipush 1000
	i2l 
	lcmp 
	ifle Label582
	aload_0_getfield .field_48_48   // get_name_1:  .field_48_48   // get_name_2:  .field_48_48   // get_Name:    .field_48_48   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 48
	iconst_0 
	aload_0_getfield .field_48_48   // get_name_1:  .field_48_48   // get_name_2:  .field_48_48   // get_Name:    .field_48_48   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 48
	invokevirtual length( java.lang.StringBuffer ) // pc=1
	invokevirtual delete( java.lang.StringBuffer, int, int ) // pc=3
	pop 
	aload_0_getfield .field_48_48   // get_name_1:  .field_48_48   // get_name_2:  .field_48_48   // get_Name:    .field_48_48   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 48
	aload_0_getfield .field_47_47   // get_name_1:  .field_47_47   // get_name_2:  .field_47_47   // get_Name:    .field_47_47   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 47
	invokevirtual append( java.lang.StringBuffer, int ) // pc=2
	pop 
	aload_0 
	iconst_0 
	putfield .field_47_47   // get_name_1:  .field_47_47   // get_name_2:  .field_47_47   // get_Name:    .field_47_47   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 47
	aload_0 
	invokestatic_lib currentTimeMillis(  ) // 
	lputfield .field_45_45   // get_name_1:  .field_45_45   // get_name_2:  .field_45_45   // get_Name:    .field_45_45   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 45
Label582:
	aload_1 
	getstatic com.plazmic.rooster.Game.field_50996 // Game
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	iipush 10066329
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	aload_0_getfield .field_48_48   // get_name_1:  .field_48_48   // get_name_2:  .field_48_48   // get_Name:    .field_48_48   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 48
	invokevirtual_short .toString // idx=2 pc=1
	bipush 120
	bipush 50
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
Label595:
	return 
	}


public final keyPressed( com.plazmic.rooster.Game, int ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_32_32   // get_name_1:  .field_32_32   // get_name_2:  .field_32_32   // get_Name:    .field_32_32   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 32
	ifne Label15
	aload_0_getfield .field_33_33   // get_name_1:  .field_33_33   // get_name_2:  .field_33_33   // get_Name:    .field_33_33   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 33
	ifne Label15
	aload_0_getfield .field_40_40   // get_name_1:  .field_40_40   // get_name_2:  .field_40_40   // get_Name:    .field_40_40   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 40
	bipush 16
	if_icmpne Label15
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iload_1 
	getstatic charMapping // Storage
	invokenonvirtual com.plazmic.rooster.Rooster.move // pc=3
	aload_0 
	iload_1 
	putfield .field_34_34   // get_name_1:  .field_34_34   // get_name_2:  .field_34_34   // get_Name:    .field_34_34   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 34
Label15:
	return 
	}


public final keyReleased( com.plazmic.rooster.Game, int ); // address: 0
	{
	enter_narrow 
	iload_1 
	sipush 137
	if_icmpeq Label13
	iload_1 
	aload_0_getfield .field_34_34   // get_name_1:  .field_34_34   // get_name_2:  .field_34_34   // get_Name:    .field_34_34   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 34
	if_icmpne Label17
	iload_1 
	iconst_1 
	if_icmpeq Label17
	iload_1 
	bipush 6
	if_icmpeq Label17
Label13:
	aload_0_getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	bipush -1
	getstatic charMapping // Storage
	invokenonvirtual com.plazmic.rooster.Rooster.move // pc=3
Label17:
	iload_1 
	bipush 27
	if_icmpne Label30
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
Label30:
	return 
	}


public final setMenu( com.plazmic.rooster.Game ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_27_27   // get_name_1:  .field_27_27   // get_name_2:  .field_27_27   // get_Name:    .field_27_27   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 27
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_26_26   // get_name_1:  .field_26_26   // get_name_2:  .field_26_26   // get_Name:    .field_26_26   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 26
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_24_24   // get_name_1:  .field_24_24   // get_name_2:  .field_24_24   // get_Name:    .field_24_24   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 24
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_25_25   // get_name_1:  .field_25_25   // get_name_2:  .field_25_25   // get_Name:    .field_25_25   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 25
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_23_23   // get_name_1:  .field_23_23   // get_name_2:  .field_23_23   // get_Name:    .field_23_23   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 23
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_28_28   // get_name_1:  .field_28_28   // get_name_2:  .field_28_28   // get_Name:    .field_28_28   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 28
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}


public final unsetMenu( com.plazmic.rooster.Game ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_27_27   // get_name_1:  .field_27_27   // get_name_2:  .field_27_27   // get_Name:    .field_27_27   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 27
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_26_26   // get_name_1:  .field_26_26   // get_name_2:  .field_26_26   // get_Name:    .field_26_26   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 26
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_24_24   // get_name_1:  .field_24_24   // get_name_2:  .field_24_24   // get_Name:    .field_24_24   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 24
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_25_25   // get_name_1:  .field_25_25   // get_name_2:  .field_25_25   // get_Name:    .field_25_25   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 25
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_23_23   // get_name_1:  .field_23_23   // get_name_2:  .field_23_23   // get_Name:    .field_23_23   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 23
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_28_28   // get_name_1:  .field_28_28   // get_name_2:  .field_28_28   // get_Name:    .field_28_28   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 28
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}

}
