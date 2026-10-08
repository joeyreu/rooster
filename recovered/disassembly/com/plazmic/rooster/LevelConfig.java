// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 12
// ########################################################


package com.plazmic.rooster;


abstract final class LevelConfig extends Object

{
	// @@@@@@@@@@@@@ Static fields 
	public static int[][] /*int[][]*/  levelDef ; // ofs = 51616 addr = 42)
	public static int[][] /*int[][]*/  laneSpeed ; // ofs = 51622 addr = 43)
	public static String /*java.lang.String[]*/  imageNames ; // ofs = 51628 addr = 44)
	public static String /*java.lang.String[]*/  roosters ; // ofs = 51634 addr = 45)
	public static String /*java.lang.String[]*/  deadRoosters ; // ofs = 51640 addr = 46)
	public static String /*java.lang.String[]*/  trafficImages ; // ofs = 51646 addr = 47)
	public static int[][] /*int[][]*/  trafficBounds ; // ofs = 51652 addr = 48)
	public static boolean[] /*boolean[]*/  drawAbove ; // ofs = 51658 addr = 49)
	public static String /*java.lang.String[]*/  obsticleImages ; // ofs = 51664 addr = 50)
	public static int[] /*int[]*/  carDensity ; // ofs = 51670 addr = 51)
	public static int[] /*int[]*/  treeDensity ; // ofs = 51676 addr = 52)
	public static int[] /*int[]*/  startCarsPassed ; // ofs = 51682 addr = 53)
	public static int[] /*int[]*/  HUDFontColour ; // ofs = 51688 addr = 54)


	// @@@@@@@@@@@@@ Static routines 

final <init>( com.plazmic.rooster.LevelConfig ); // address: 0
	{
	jumpspecial_lib <init>( java.lang.Object )
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	synch_static LevelConfig
	clinit_wait 
	bipush 20
	multianewarray  // dim=1 nest=2 type=5
	dup 
	iconst_0 
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	iconst_1 
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 2
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 3
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 4
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 5
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 6
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 7
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 8
	arrayinit [1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0]
	aastore 
	dup 
	bipush 9
	arrayinit [1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0]
	aastore 
	dup 
	bipush 10
	arrayinit [1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0]
	aastore 
	dup 
	bipush 11
	arrayinit [1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 12
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 13
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 14
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 15
	arrayinit [4, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 16
	arrayinit [1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0]
	aastore 
	dup 
	bipush 17
	arrayinit [1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0]
	aastore 
	dup 
	bipush 18
	arrayinit [1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0]
	aastore 
	dup 
	bipush 19
	arrayinit [1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0]
	aastore 
	putstatic levelDef // LevelConfig
	bipush 20
	multianewarray  // dim=1 nest=2 type=5
	dup 
	iconst_0 
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, -3, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	iconst_1 
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -2, -1, -1, -1, -3, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 2
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -3, -1, -1, -1, -1, -1, -1, -1, -3, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 3
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -3, -1, -1, -1, -2, -1, -1, -1, -2, -1, -1, -1, -3, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 4
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -2, -1, -1, -1, 3, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, -3, -1, -1, -1, 0, 0, 0, 0, 4, 0, 0, 0, -4, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 5
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -2, -1, -1, -1, 3, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -2, -1, -1, -1, 3, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 6
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -2, -1, -1, -1, -3, -1, -1, -1, 4, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -3, -1, -1, -1, 4, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, -4, -1, -1, -1, -3, -1, -1, -1, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 7
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -2, -1, -1, -1, -3, -1, -1, -1, 4, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -3, -1, -1, -1, 4, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, -4, -1, -1, -1, -3, -1, -1, -1, 4, 0, 0, 0, -3, -1, -1, -1, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 8
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, -4, -1, -1, -1, 1, 0, 0, 0, -4, -1, -1, -1, 0, 0, 0, 0, -4, -1, -1, -1, 3, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, -3, -1, -1, -1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 9
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, -4, -1, -1, -1, 3, 0, 0, 0, -3, -1, -1, -1, 0, 0, 0, 0, -1, -1, -1, -1, 1, 0, 0, 0, -1, -1, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, -4, -1, -1, -1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 10
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, -4, -1, -1, -1, 4, 0, 0, 0, -3, -1, -1, -1, 2, 0, 0, 0, -1, -1, -1, -1, 0, 0, 0, 0, -1, -1, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, -2, -1, -1, -1, 3, 0, 0, 0, 4, 0, 0, 0, -5, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 11
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, -4, -1, -1, -1, 4, 0, 0, 0, -3, -1, -1, -1, 2, 0, 0, 0, -1, -1, -1, -1, 0, 0, 0, 0, -1, -1, -1, -1, 1, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, -2, -1, -1, -1, 3, 0, 0, 0, 4, 0, 0, 0, -5, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 12
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -5, -1, -1, -1, 5, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, -5, -1, -1, -1, 0, 0, 0, 0, 5, 0, 0, 0, -5, -1, -1, -1, 0, 0, 0, 0, 5, 0, 0, 0, -5, -1, -1, -1, 0, 0, 0, 0, 5, 0, 0, 0, -5, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 13
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -5, -1, -1, -1, -6, -1, -1, -1, 5, 0, 0, 0, 0, 0, 0, 0, -5, -1, -1, -1, 6, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, -6, -1, -1, -1, -1, -1, -1, -1, 6, 0, 0, 0, 0, 0, 0, 0, -6, -1, -1, -1, -1, -1, -1, -1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 14
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -6, -1, -1, -1, -4, -1, -1, -1, 4, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, -4, -1, -1, -1, -6, -1, -1, -1, 6, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, -4, -1, -1, -1, -6, -1, -1, -1, 4, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, -4, -1, -1, -1, -6, -1, -1, -1, 4, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 15
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, -6, -1, -1, -1, -4, -1, -1, -1, 4, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, -4, -1, -1, -1, -6, -1, -1, -1, 6, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, -4, -1, -1, -1, -6, -1, -1, -1, 4, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, -4, -1, -1, -1, -6, -1, -1, -1, 4, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 16
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, -7, -1, -1, -1, 3, 0, 0, 0, -7, -1, -1, -1, -7, -1, -1, -1, 7, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, -7, -1, -1, -1, 3, 0, 0, 0, -7, -1, -1, -1, -7, -1, -1, -1, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 17
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, -6, -1, -1, -1, 7, 0, 0, 0, -5, -1, -1, -1, -7, -1, -1, -1, 8, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, -8, -1, -1, -1, 7, 0, 0, 0, -6, -1, -1, -1, -3, -1, -1, -1, 4, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, -8, -1, -1, -1, 3, 0, 0, 0, -6, -1, -1, -1, -3, -1, -1, -1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 18
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, -9, -1, -1, -1, 8, 0, 0, 0, -7, -1, -1, -1, 6, 0, 0, 0, -6, -1, -1, -1, 7, 0, 0, 0, -8, -1, -1, -1, 9, 0, 0, 0, -10, -1, -1, -1, 0, 0, 0, 0, 10, 0, 0, 0, -9, -1, -1, -1, 8, 0, 0, 0, -7, -1, -1, -1, 6, 0, 0, 0, -6, -1, -1, -1, 7, 0, 0, 0, -8, -1, -1, -1, 9, 0, 0, 0, -10, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	dup 
	bipush 19
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, -9, -1, -1, -1, 10, 0, 0, 0, -9, -1, -1, -1, 10, 0, 0, 0, -9, -1, -1, -1, 10, 0, 0, 0, -9, -1, -1, -1, 10, 0, 0, 0, -9, -1, -1, -1, 0, 0, 0, 0, 10, 0, 0, 0, -9, -1, -1, -1, 10, 0, 0, 0, -9, -1, -1, -1, 10, 0, 0, 0, -9, -1, -1, -1, 10, 0, 0, 0, -9, -1, -1, -1, 10, 0, 0, 0, -9, -1, -1, -1, 0, 0, 0, 0, 12, 0, 0, 0, -12, -1, -1, -1, 12, 0, 0, 0, -12, -1, -1, -1, 12, 0, 0, 0, 0, 0, 0, 0]
	aastore 
	putstatic laneSpeed // LevelConfig
	op01xx 
	stringarrayinit [level1Background.png, level1Background.png, level1Background.png, level1Background.png, level2Background.png, level2Background.png, level2Background.png, level2Background.png, bg_level_water_8.png, bg_level_water_8.png, bg_level_water_8.png, bg_level_water_8.png, bg_level_steel_8.png, bg_level_steel_8.png, bg_level_steel_8.png, bg_level_steel_8.png, bg_level_space_8.png, bg_level_space_8.png, bg_level_space_8.png, bg_level_space_8.png]
	putstatic imageNames // LevelConfig
	op01xx 
	stringarrayinit [rooster.png, rooster.png, rooster.png, rooster.png, rooster.png, rooster.png, rooster.png, rooster.png, roosterBoat.png, roosterBoat.png, roosterBoat.png, roosterBoat.png, roosterTank.png, roosterTank.png, roosterTank.png, roosterTank.png, roosterSpace.png, roosterSpace.png, roosterSpace.png, roosterSpace.png]
	putstatic roosters // LevelConfig
	op01xx 
	stringarrayinit [deadRooster.png, deadRooster.png, deadRooster.png, deadRooster.png, deadRooster.png, deadRooster.png, deadRooster.png, deadRooster.png, deadRooster_boat.png, deadRooster_boat.png, deadRooster_boat.png, deadRooster_boat.png, deadRooster_tank.png, deadRooster_tank.png, deadRooster_tank.png, deadRooster_tank.png, deadRooster_space.png, deadRooster_space.png, deadRooster_space.png, deadRooster_space.png]
	putstatic deadRoosters // LevelConfig
	op01xx 
	stringarrayinit [cars_1.png, cars_1.png, cars_1.png, cars_1.png, cars_1.png, cars_1.png, cars_1.png, cars_1.png, boats_1.png, boats_1.png, boats_1.png, boats_1.png, merc_1.png, merc_1.png, merc_1.png, merc_1.png, ships_1.png, ships_1.png, ships_1.png, ships_1.png]
	putstatic trafficImages // LevelConfig
	bipush 20
	multianewarray  // dim=1 nest=2 type=5
	dup 
	iconst_0 
	arrayinit [-1, -1, -1, -1, 33, 0, 0, 0, 68, 0, 0, 0, 94, 0, 0, 0, 121, 0, 0, 0, -110, 0, 0, 0, -83, 0, 0, 0, -56, 0, 0, 0, -28, 0, 0, 0, 39, 1, 0, 0, 102, 1, 0, 0]
	aastore 
	dup 
	iconst_1 
	arrayinit [-1, -1, -1, -1, 33, 0, 0, 0, 68, 0, 0, 0, 94, 0, 0, 0, 121, 0, 0, 0, -110, 0, 0, 0, -83, 0, 0, 0, -56, 0, 0, 0, -28, 0, 0, 0, 39, 1, 0, 0, 102, 1, 0, 0]
	aastore 
	dup 
	bipush 2
	arrayinit [-1, -1, -1, -1, 33, 0, 0, 0, 68, 0, 0, 0, 94, 0, 0, 0, 121, 0, 0, 0, -110, 0, 0, 0, -83, 0, 0, 0, -56, 0, 0, 0, -28, 0, 0, 0, 39, 1, 0, 0, 102, 1, 0, 0]
	aastore 
	dup 
	bipush 3
	arrayinit [-1, -1, -1, -1, 33, 0, 0, 0, 68, 0, 0, 0, 94, 0, 0, 0, 121, 0, 0, 0, -110, 0, 0, 0, -83, 0, 0, 0, -56, 0, 0, 0, -28, 0, 0, 0, 39, 1, 0, 0, 102, 1, 0, 0]
	aastore 
	dup 
	bipush 4
	arrayinit [-1, -1, -1, -1, 33, 0, 0, 0, 68, 0, 0, 0, 94, 0, 0, 0, 121, 0, 0, 0, -110, 0, 0, 0, -83, 0, 0, 0, -56, 0, 0, 0, -28, 0, 0, 0, 39, 1, 0, 0, 102, 1, 0, 0]
	aastore 
	dup 
	bipush 5
	arrayinit [-1, -1, -1, -1, 33, 0, 0, 0, 68, 0, 0, 0, 94, 0, 0, 0, 121, 0, 0, 0, -110, 0, 0, 0, -83, 0, 0, 0, -56, 0, 0, 0, -28, 0, 0, 0, 39, 1, 0, 0, 102, 1, 0, 0]
	aastore 
	dup 
	bipush 6
	arrayinit [-1, -1, -1, -1, 33, 0, 0, 0, 68, 0, 0, 0, 94, 0, 0, 0, 121, 0, 0, 0, -110, 0, 0, 0, -83, 0, 0, 0, -56, 0, 0, 0, -28, 0, 0, 0, 39, 1, 0, 0, 102, 1, 0, 0]
	aastore 
	dup 
	bipush 7
	arrayinit [-1, -1, -1, -1, 33, 0, 0, 0, 68, 0, 0, 0, 94, 0, 0, 0, 121, 0, 0, 0, -110, 0, 0, 0, -83, 0, 0, 0, -56, 0, 0, 0, -28, 0, 0, 0, 39, 1, 0, 0, 102, 1, 0, 0]
	aastore 
	dup 
	bipush 8
	arrayinit [-1, -1, -1, -1, 53, 0, 0, 0, 101, 0, 0, 0, -109, 0, 0, 0, -35, 0, 0, 0, 2, 1, 0, 0, 38, 1, 0, 0, 123, 1, 0, 0]
	aastore 
	dup 
	bipush 9
	arrayinit [-1, -1, -1, -1, 53, 0, 0, 0, 101, 0, 0, 0, -109, 0, 0, 0, -35, 0, 0, 0, 2, 1, 0, 0, 38, 1, 0, 0, 123, 1, 0, 0]
	aastore 
	dup 
	bipush 10
	arrayinit [-1, -1, -1, -1, 53, 0, 0, 0, 101, 0, 0, 0, -109, 0, 0, 0, -35, 0, 0, 0, 2, 1, 0, 0, 38, 1, 0, 0, 123, 1, 0, 0]
	aastore 
	dup 
	bipush 11
	arrayinit [-1, -1, -1, -1, 53, 0, 0, 0, 101, 0, 0, 0, -109, 0, 0, 0, -35, 0, 0, 0, 2, 1, 0, 0, 38, 1, 0, 0, 123, 1, 0, 0]
	aastore 
	dup 
	bipush 12
	arrayinit [-1, -1, -1, -1, 44, 0, 0, 0, 76, 0, 0, 0, 94, 0, 0, 0, 118, 0, 0, 0, -118, 0, 0, 0, -103, 0, 0, 0, -42, 0, 0, 0]
	aastore 
	dup 
	bipush 13
	arrayinit [-1, -1, -1, -1, 44, 0, 0, 0, 76, 0, 0, 0, 94, 0, 0, 0, 118, 0, 0, 0, -118, 0, 0, 0, -104, 0, 0, 0, -42, 0, 0, 0]
	aastore 
	dup 
	bipush 14
	arrayinit [-1, -1, -1, -1, 44, 0, 0, 0, 76, 0, 0, 0, 94, 0, 0, 0, 118, 0, 0, 0, -118, 0, 0, 0, -104, 0, 0, 0, -42, 0, 0, 0]
	aastore 
	dup 
	bipush 15
	arrayinit [-1, -1, -1, -1, 44, 0, 0, 0, 76, 0, 0, 0, 94, 0, 0, 0, 118, 0, 0, 0, -118, 0, 0, 0, -104, 0, 0, 0, -42, 0, 0, 0]
	aastore 
	dup 
	bipush 16
	arrayinit [-1, -1, -1, -1, 24, 0, 0, 0, 48, 0, 0, 0, 73, 0, 0, 0, 118, 0, 0, 0, -120, 0, 0, 0]
	aastore 
	dup 
	bipush 17
	arrayinit [-1, -1, -1, -1, 24, 0, 0, 0, 48, 0, 0, 0, 73, 0, 0, 0, 118, 0, 0, 0, -120, 0, 0, 0]
	aastore 
	dup 
	bipush 18
	arrayinit [-1, -1, -1, -1, 24, 0, 0, 0, 48, 0, 0, 0, 73, 0, 0, 0, 118, 0, 0, 0, -120, 0, 0, 0]
	aastore 
	dup 
	bipush 19
	arrayinit [-1, -1, -1, -1, 24, 0, 0, 0, 48, 0, 0, 0, 73, 0, 0, 0, 118, 0, 0, 0, -120, 0, 0, 0]
	aastore 
	putstatic trafficBounds // LevelConfig
	arrayinit [1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0]
	putstatic drawAbove // LevelConfig
	op01xx 
	stringarrayinit [obstacles_grass1.png, obstacles_grass1.png, obstacles_grass1.png, obstacles_grass1.png, obstacles_desert1.png, obstacles_desert1.png, obstacles_desert1.png, obstacles_desert1.png, obstacles_water1.png, obstacles_water1.png, obstacles_water1.png, obstacles_water1.png, obstacles_metal1.png, obstacles_metal1.png, obstacles_metal1.png, obstacles_metal1.png, obstacles_space1.png, obstacles_space1.png, obstacles_space1.png, obstacles_space1.png]
	putstatic obsticleImages // LevelConfig
	arrayinit [6, 0, 0, 0, 12, 0, 0, 0, 13, 0, 0, 0, 14, 0, 0, 0, 15, 0, 0, 0, 20, 0, 0, 0, 25, 0, 0, 0, 30, 0, 0, 0, 25, 0, 0, 0, 25, 0, 0, 0, 25, 0, 0, 0, 30, 0, 0, 0, 30, 0, 0, 0, 30, 0, 0, 0, 35, 0, 0, 0, 40, 0, 0, 0, 40, 0, 0, 0, 40, 0, 0, 0, 50, 0, 0, 0, 70, 0, 0, 0]
	putstatic carDensity // LevelConfig
	arrayinit [20, 0, 0, 0, 20, 0, 0, 0, 20, 0, 0, 0, 20, 0, 0, 0, 20, 0, 0, 0, 20, 0, 0, 0, 20, 0, 0, 0, 20, 0, 0, 0, 25, 0, 0, 0, 25, 0, 0, 0, 25, 0, 0, 0, 25, 0, 0, 0, 30, 0, 0, 0, 30, 0, 0, 0, 30, 0, 0, 0, 30, 0, 0, 0, 35, 0, 0, 0, 35, 0, 0, 0, 40, 0, 0, 0, 40, 0, 0, 0]
	putstatic treeDensity // LevelConfig
	arrayinit [60, 0, 0, 0, 60, 0, 0, 0, 70, 0, 0, 0, 80, 0, 0, 0, 80, 0, 0, 0, 80, 0, 0, 0, 100, 0, 0, 0, -106, 0, 0, 0, 110, 0, 0, 0, 110, 0, 0, 0, 120, 0, 0, 0, -96, 0, 0, 0, 120, 0, 0, 0, -116, 0, 0, 0, -106, 0, 0, 0, -96, 0, 0, 0, -96, 0, 0, 0, -86, 0, 0, 0, -76, 0, 0, 0, -16, 0, 0, 0]
	putstatic startCarsPassed // LevelConfig
	arrayinit [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0]
	putstatic HUDFontColour // LevelConfig
	clinit_return 
	}

}
