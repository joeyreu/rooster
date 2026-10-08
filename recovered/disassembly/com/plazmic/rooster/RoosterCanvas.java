// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 19
// ########################################################


package com.plazmic.rooster;


abstract public final class RoosterCanvas extends javax.microedition.lcdui.game.GameCanvas
implements Runnable, javax.microedition.lcdui.CommandListener

{
	// @@@@@@@@@@@@@ Static fields 
	private final static com.plazmic.rooster.LevelConfig /*com.plazmic.rooster.LevelConfig*/  field_52498 ; // ofs = 52498 addr = 76)

	// @@@@@@@@@@@@@ Fields 
	public com.plazmic.rooster.RoosterMIDlet /*com.plazmic.rooster.RoosterMIDlet*/  parent ; // ofs = 52398 addr = 0)
	private com.plazmic.rooster.Splash /*com.plazmic.rooster.Splash*/  field_52402 ; // ofs = 52402 addr = 0)
	private com.plazmic.rooster.Loading /*com.plazmic.rooster.Loading*/  field_52406 ; // ofs = 52406 addr = 0)
	private com.plazmic.rooster.Finale /*com.plazmic.rooster.Finale*/  field_52410 ; // ofs = 52410 addr = 0)
	private com.plazmic.rooster.About /*com.plazmic.rooster.About*/  field_52414 ; // ofs = 52414 addr = 0)
	protected com.plazmic.rooster.Pause /*com.plazmic.rooster.Pause*/  pause ; // ofs = 52418 addr = 0)
	protected com.plazmic.rooster.Confirm /*com.plazmic.rooster.Confirm*/  confirm ; // ofs = 52422 addr = 0)
	private com.plazmic.rooster.Storage /*com.plazmic.rooster.Storage*/  field_52426 ; // ofs = 52426 addr = 0)
	private com.plazmic.rooster.NextLevel /*com.plazmic.rooster.NextLevel*/  field_52430 ; // ofs = 52430 addr = 0)
	public com.plazmic.rooster.EnterName /*com.plazmic.rooster.EnterName*/  enterName ; // ofs = 52434 addr = 0)
	private com.plazmic.rooster.KeyMapper /*com.plazmic.rooster.KeyMapper*/  field_52438 ; // ofs = 52438 addr = 0)
	public com.plazmic.rooster.Game /*com.plazmic.rooster.Game*/  game ; // ofs = 52442 addr = 0)
	public com.plazmic.rooster.HighScores /*com.plazmic.rooster.HighScores*/  highScores ; // ofs = 52446 addr = 0)
	private com.plazmic.rooster.Mode /*com.plazmic.rooster.Mode*/  field_52450 ; // ofs = 52450 addr = 0)
	private boolean /*boolean*/  field_52454 ; // ofs = 52454 addr = 0)
	private int /*int*/  field_52458 ; // ofs = 52458 addr = 0)
	public final int /*int*/  TRANSLATEX ; // ofs = 52462 addr = 0)
	public final int /*int*/  TRANSLATEY ; // ofs = 52466 addr = 0)
	private int /*int*/  field_52470 ; // ofs = 52470 addr = 0)
	public javax.microedition.lcdui.Graphics /*javax.microedition.lcdui.Graphics*/  g ; // ofs = 52474 addr = 0)
	private boolean /*boolean*/  field_52478 ; // ofs = 52478 addr = 0)
	private boolean /*boolean*/  field_52482 ; // ofs = 52482 addr = 0)
	private boolean /*boolean*/  field_52486 ; // ofs = 52486 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_52490 ; // ofs = 52490 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_52494 ; // ofs = 52494 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	xenter 
	aload_0 
	iconst_0 
	invokespecial_lib javax.microedition.lcdui.game.GameCanvas.<init> // pc=2
	aload_0 
	new Splash
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.Splash.<init> // pc=2
	putfield com.plazmic.rooster.RoosterCanvas.field_52402   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52402   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52402   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52402   // getName->1:     // getName->2:     // getName->N:     // ofs = 52402 ord = 1 addr = 0
	aload_0 
	new Loading
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.Loading.<init> // pc=2
	putfield com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52406   // getName->1:     // getName->2:     // getName->N:     // ofs = 52406 ord = 2 addr = 0
	aload_0 
	new About
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.About.<init> // pc=2
	putfield com.plazmic.rooster.RoosterCanvas.field_52414   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52414   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52414   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52414   // getName->1:     // getName->2:     // getName->N:     // ofs = 52414 ord = 4 addr = 0
	aload_0 
	new Pause
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.Pause.<init> // pc=2
	putfield pause   // get_name_1:  pause   // get_name_2:  pause   // get_Name:    pause   // getName->1:  pause   // getName->2:  pause   // getName->N:  pause   // ofs = 52418 ord = 5 addr = 0
	aload_0 
	new Confirm
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.Confirm.<init> // pc=2
	putfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	aload_0 
	new Storage
	dup 
	invokespecial com.plazmic.rooster.Storage.<init> // pc=1
	putfield com.plazmic.rooster.RoosterCanvas.field_52426   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52426   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52426   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52426   // getName->1:     // getName->2:     // getName->N:     // ofs = 52426 ord = 7 addr = 0
	aload_0 
	new NextLevel
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.NextLevel.<init> // pc=2
	putfield com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52430   // getName->1:     // getName->2:     // getName->N:     // ofs = 52430 ord = 8 addr = 0
	aload_0 
	new EnterName
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.EnterName.<init> // pc=2
	putfield enterName   // get_name_1:  enterName   // get_name_2:  enterName   // get_Name:    enterName   // getName->1:  enterName   // getName->2:  enterName   // getName->N:  enterName   // ofs = 52434 ord = 9 addr = 0
	aload_0 
	new KeyMapper
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.KeyMapper.<init> // pc=2
	putfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52454   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52454   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52454   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52454   // getName->1:     // getName->2:     // getName->N:     // ofs = 52454 ord = 14 addr = 0
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	aload_0 
	aload_0 
	invokevirtual getWidth( javax.microedition.lcdui.Displayable ) // pc=1
	sipush 240
	isub 
	bipush 2
	idiv 
	putfield TRANSLATEX   // get_name_1:  TRANSLATEX   // get_name_2:  TRANSLATEX   // get_Name:    TRANSLATEX   // getName->1:  TRANSLATEX   // getName->2:  TRANSLATEX   // getName->N:  TRANSLATEX   // ofs = 52462 ord = 16 addr = 0
	aload_0 
	aload_0 
	invokevirtual getHeight( javax.microedition.lcdui.Displayable ) // pc=1
	sipush 160
	isub 
	bipush 2
	idiv 
	putfield TRANSLATEY   // get_name_1:  TRANSLATEY   // get_name_2:  TRANSLATEY   // get_Name:    TRANSLATEY   // getName->1:  TRANSLATEY   // getName->2:  TRANSLATEY   // getName->N:  TRANSLATEY   // ofs = 52466 ord = 17 addr = 0
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52470   // getName->1:     // getName->2:     // getName->N:     // ofs = 52470 ord = 18 addr = 0
	aload_0 
	aload_0 
	invokevirtual getGraphics( javax.microedition.lcdui.game.GameCanvas ) // pc=1
	putfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52478   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52478   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52478   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52478   // getName->1:     // getName->2:     // getName->N:     // ofs = 52478 ord = 20 addr = 0
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52482   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52482   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52482   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52482   // getName->1:     // getName->2:     // getName->N:     // ofs = 52482 ord = 21 addr = 0
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52486   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52486   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52486   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52486   // getName->1:     // getName->2:     // getName->N:     // ofs = 52486 ord = 22 addr = 0
	aload_0 
	aconst_null 
	putfield com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52490   // getName->1:     // getName->2:     // getName->N:     // ofs = 52490 ord = 23 addr = 0
	aload_0 
	aconst_null 
	putfield com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52494   // getName->1:     // getName->2:     // getName->N:     // ofs = 52494 ord = 24 addr = 0
	aload_0 
	aload_0 
	invokevirtual setCommandListener( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.CommandListener ) // pc=2
	aload_0 
	ldc literal_106:"img/top.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52494   // getName->1:     // getName->2:     // getName->N:     // ofs = 52494 ord = 24 addr = 0
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52494   // getName->1:     // getName->2:     // getName->N:     // ofs = 52494 ord = 24 addr = 0
	iconst_0 
	iconst_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52494   // getName->1:     // getName->2:     // getName->N:     // ofs = 52494 ord = 24 addr = 0
	invokevirtual getWidth( javax.microedition.lcdui.Image ) // pc=1
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52494   // getName->1:     // getName->2:     // getName->N:     // ofs = 52494 ord = 24 addr = 0
	invokevirtual getHeight( javax.microedition.lcdui.Image ) // pc=1
	bipush 3
	invokestatic_lib createImage( javax.microedition.lcdui.Image, int, int, int, int, int ) // 
	putfield com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52490   // getName->1:     // getName->2:     // getName->N:     // ofs = 52490 ord = 23 addr = 0
	goto Label124
	astore_1 
	getstatic_lib out // System
	ldc literal_107:"Couldn't find the border pictures."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
Label124:
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52402   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52402   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52402   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52402   // getName->1:     // getName->2:     // getName->N:     // ofs = 52402 ord = 1 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	invokevirtual_short .virtual_6 // idx=6 pc=1
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit_lib javax.microedition.lcdui.game.GameCanvas//javax.microedition.lcdui.game.GameCanvas javax.microedition.lcdui.game.GameCanvas javax.microedition.lcdui.game.GameCanvas
	synch_static RoosterCanvas
	clinit_wait 
	new LevelConfig
	dup 
	invokespecial com.plazmic.rooster.LevelConfig.<init> // pc=1
	putstatic com.plazmic.rooster.RoosterCanvas.field_52498 // RoosterCanvas
	clinit_return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final setParent( com.plazmic.rooster.RoosterCanvas, com.plazmic.rooster.RoosterMIDlet ); // address: 0
	{
	putfield_return parent   // get_name_1:  parent   // get_name_2:  parent   // get_Name:    parent   // getName->1:  parent   // getName->2:  parent   // getName->N:  parent   // ofs = 52398 ord = 0 addr = 0
	}


public final enableFPSDisplay( com.plazmic.rooster.RoosterCanvas, boolean ); // address: 0
	{
	putfield_return com.plazmic.rooster.RoosterCanvas.field_52482   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52482   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52482   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52482   // getName->1:     // getName->2:     // getName->N:     // ofs = 52482 ord = 21 addr = 0
	}


public final switchToMode( com.plazmic.rooster.RoosterCanvas, int ); // address: 0
	{
	enter 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	invokevirtual_short .virtual_7 // idx=7 pc=1
	iload_1 
	tableswitch  :
		
		
		
		
		
		
		
		
		
		

Label5:
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52402   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52402   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52402   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52402   // getName->1:     // getName->2:     // getName->N:     // ofs = 52402 ord = 1 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52470   // getName->1:     // getName->2:     // getName->N:     // ofs = 52470 ord = 18 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52402   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52402   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52402   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52402   // getName->1:     // getName->2:     // getName->N:     // ofs = 52402 ord = 1 addr = 0
	invokenonvirtual com.plazmic.rooster.Splash.reset // pc=1
	goto_w Label147
Label14:
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52406   // getName->1:     // getName->2:     // getName->N:     // ofs = 52406 ord = 2 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	aload_0_getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	ifnonnull Label28
	aload_0 
	new Game
	dup 
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52470   // getName->1:     // getName->2:     // getName->N:     // ofs = 52470 ord = 18 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52406   // getName->1:     // getName->2:     // getName->N:     // ofs = 52406 ord = 2 addr = 0
	invokespecial com.plazmic.rooster.Game.<init> // pc=4
	putfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	goto Label49
Label28:
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	bipush 7
	if_icmpeq Label49
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	bipush 3
	if_icmpeq Label49
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	bipush 8
	if_icmpne Label44
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	bipush 8
	if_icmpne Label49
	aload_0_getfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	invokenonvirtual com.plazmic.rooster.Confirm.getUsage // pc=1
	iconst_1 
	if_icmpne Label49
Label44:
	aload_0_getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52470   // getName->1:     // getName->2:     // getName->N:     // ofs = 52470 ord = 18 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52406   // getName->1:     // getName->2:     // getName->N:     // ofs = 52406 ord = 2 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52478   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52478   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52478   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52478   // getName->1:     // getName->2:     // getName->N:     // ofs = 52478 ord = 20 addr = 0
	invokenonvirtual com.plazmic.rooster.Game.reset // pc=4
Label49:
	aload_0_getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52482   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52482   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52482   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52482   // getName->1:     // getName->2:     // getName->N:     // ofs = 52482 ord = 21 addr = 0
	invokenonvirtual com.plazmic.rooster.Game.enableFPSDisplay // pc=2
	aload_0_getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52486   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52486   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52486   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52486   // getName->1:     // getName->2:     // getName->N:     // ofs = 52486 ord = 22 addr = 0
	invokenonvirtual com.plazmic.rooster.Game.enablePsychoMode // pc=2
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52478   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52478   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52478   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52478   // getName->1:     // getName->2:     // getName->N:     // ofs = 52478 ord = 20 addr = 0
	aload_0 
	aload_0_getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	goto_w Label147
Label62:
	aload_0_getfield enterName   // get_name_1:  enterName   // get_name_2:  enterName   // get_Name:    enterName   // getName->1:  enterName   // getName->2:  enterName   // getName->N:  enterName   // ofs = 52434 ord = 9 addr = 0
	invokenonvirtual com.plazmic.rooster.EnterName.reset // pc=1
	aload_0 
	aload_0_getfield enterName   // get_name_1:  enterName   // get_name_2:  enterName   // get_Name:    enterName   // getName->1:  enterName   // getName->2:  enterName   // getName->N:  enterName   // ofs = 52434 ord = 9 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	goto_w Label147
Label68:
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	invokenonvirtual com.plazmic.rooster.KeyMapper.setMode // pc=2
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	goto_w Label147
Label75:
	aload_0_getfield highScores   // get_name_1:  highScores   // get_name_2:  highScores   // get_Name:    highScores   // getName->1:  highScores   // getName->2:  highScores   // getName->N:  highScores   // ofs = 52446 ord = 12 addr = 0
	ifnonnull Label83
	aload_0 
	new HighScores
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.HighScores.<init> // pc=2
	putfield highScores   // get_name_1:  highScores   // get_name_2:  highScores   // get_Name:    highScores   // getName->1:  highScores   // getName->2:  highScores   // getName->N:  highScores   // ofs = 52446 ord = 12 addr = 0
Label83:
	aload_0_getfield highScores   // get_name_1:  highScores   // get_name_2:  highScores   // get_Name:    highScores   // getName->1:  highScores   // getName->2:  highScores   // getName->N:  highScores   // ofs = 52446 ord = 12 addr = 0
	invokenonvirtual com.plazmic.rooster.HighScores.init // pc=1
	aload_0 
	aload_0_getfield highScores   // get_name_1:  highScores   // get_name_2:  highScores   // get_Name:    highScores   // getName->1:  highScores   // getName->2:  highScores   // getName->N:  highScores   // ofs = 52446 ord = 12 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	goto Label147
Label89:
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52470   // getName->1:     // getName->2:     // getName->N:     // ofs = 52470 ord = 18 addr = 0
	getstatic levelDef // LevelConfig
	arraylength 
	iconst_1 
	isub 
	if_icmpne Label110
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52406   // getName->1:     // getName->2:     // getName->N:     // ofs = 52406 ord = 2 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	aload_0 
	new Finale
	dup 
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52406   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52406   // getName->1:     // getName->2:     // getName->N:     // ofs = 52406 ord = 2 addr = 0
	aload_0_getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	invokespecial com.plazmic.rooster.Finale.<init> // pc=4
	putfield com.plazmic.rooster.RoosterCanvas.field_52410   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52410   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52410   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52410   // getName->1:     // getName->2:     // getName->N:     // ofs = 52410 ord = 3 addr = 0
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52410   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52410   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52410   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52410   // getName->1:     // getName->2:     // getName->N:     // ofs = 52410 ord = 3 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	goto Label147
Label110:
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	bipush 8
	if_icmpeq Label130
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52430   // getName->1:     // getName->2:     // getName->N:     // ofs = 52430 ord = 8 addr = 0
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52470   // getName->1:     // getName->2:     // getName->N:     // ofs = 52470 ord = 18 addr = 0
	iconst_1 
	iadd 
	dup_x1 
	putfield com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52470   // getName->1:     // getName->2:     // getName->N:     // ofs = 52470 ord = 18 addr = 0
	invokenonvirtual com.plazmic.rooster.NextLevel.setLevel // pc=2
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52430   // getName->1:     // getName->2:     // getName->N:     // ofs = 52430 ord = 8 addr = 0
	aload_0_getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.getScore // pc=1
	invokenonvirtual com.plazmic.rooster.NextLevel.setScore // pc=2
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52430   // getName->1:     // getName->2:     // getName->N:     // ofs = 52430 ord = 8 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	goto Label147
Label130:
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52430   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52430   // getName->1:     // getName->2:     // getName->N:     // ofs = 52430 ord = 8 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	goto Label147
Label134:
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52414   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52414   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52414   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52414   // getName->1:     // getName->2:     // getName->N:     // ofs = 52414 ord = 4 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	goto Label147
Label138:
	aload_0 
	aload_0_getfield pause   // get_name_1:  pause   // get_name_2:  pause   // get_Name:    pause   // getName->1:  pause   // getName->2:  pause   // getName->N:  pause   // ofs = 52418 ord = 5 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	goto Label147
Label142:
	aload_0_getfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	invokenonvirtual com.plazmic.rooster.Confirm.reset // pc=1
	aload_0 
	aload_0_getfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	putfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
Label147:
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	invokevirtual_short .virtual_6 // idx=6 pc=1
	aload_0 
	iload_1 
	putfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	return 
	}


public final terminate( com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	enter_narrow 
	aload_0 
	iconst_1 
	putfield com.plazmic.rooster.RoosterCanvas.field_52454   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52454   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52454   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52454   // getName->1:     // getName->2:     // getName->N:     // ofs = 52454 ord = 14 addr = 0
	return 
	}


public final levelJumpSet( com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	enter_narrow 
	aload_0 
	iconst_1 
	putfield com.plazmic.rooster.RoosterCanvas.field_52478   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52478   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52478   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52478   // getName->1:     // getName->2:     // getName->N:     // ofs = 52478 ord = 20 addr = 0
	return 
	}


public final setLevel( com.plazmic.rooster.RoosterCanvas, int ); // address: 0
	{
	enter_narrow 
	iload_1 
	iflt Label9
	iload_1 
	bipush 19
	if_icmpgt Label9
	aload_0 
	iload_1 
	putfield com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52470   // getName->1:     // getName->2:     // getName->N:     // ofs = 52470 ord = 18 addr = 0
Label9:
	return 
	}


public final enablePsychoMode( com.plazmic.rooster.RoosterCanvas, boolean ); // address: 0
	{
	putfield_return com.plazmic.rooster.RoosterCanvas.field_52486   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52486   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52486   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52486   // getName->1:     // getName->2:     // getName->N:     // ofs = 52486 ord = 22 addr = 0
	}


public final commandAction( com.plazmic.rooster.RoosterCanvas, javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable ); // address: 0
	{
	enter 
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label27
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_45:"Settings"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label27
	aload_0 
	bipush 3
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	iconst_1 
	if_icmpeq Label22
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	bipush 7
	if_icmpeq Label22
	goto_w Label258
Label22:
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	invokevirtual_short .virtual_7 // idx=7 pc=1
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	invokenonvirtual com.plazmic.rooster.KeyMapper.setGameMenu // pc=1
	return 
Label27:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label42
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_61:"Default Settings"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label42
	invokestatic byte[] resetMapping(  ) // Storage
	pop 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	invokestatic byte[] getMapping(  ) // Storage
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	return 
Label42:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label55
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_17:"Start Screen"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label55
	aload_0 
	iconst_0 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label55:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label73
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_62:"Return To Game"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label73
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	invokenonvirtual com.plazmic.rooster.KeyMapper.unsetGameMenu // pc=1
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	invokevirtual_short .virtual_6 // idx=6 pc=1
	aload_0 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	getfield .field_10_10   // get_name_1:  .field_10_10   // get_name_2:  .field_10_10   // get_Name:    .field_10_10   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 10
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label73:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label92
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_46:"Quit Game"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label92
	aload_0_getfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	iconst_0 
	invokenonvirtual com.plazmic.rooster.Confirm.setUsage // pc=2
	aload_0_getfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	invokenonvirtual com.plazmic.rooster.Confirm.setPreviousMode // pc=2
	aload_0 
	bipush 8
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label92:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label116
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_102:"High Scores"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label116
	aload_0_getfield highScores   // get_name_1:  highScores   // get_name_2:  highScores   // get_Name:    highScores   // getName->1:  highScores   // getName->2:  highScores   // getName->N:  highScores   // ofs = 52446 ord = 12 addr = 0
	ifnonnull Label109
	aload_0 
	new HighScores
	dup 
	aload_0 
	invokespecial com.plazmic.rooster.HighScores.<init> // pc=2
	putfield highScores   // get_name_1:  highScores   // get_name_2:  highScores   // get_Name:    highScores   // getName->1:  highScores   // getName->2:  highScores   // getName->N:  highScores   // ofs = 52446 ord = 12 addr = 0
Label109:
	aload_0_getfield highScores   // get_name_1:  highScores   // get_name_2:  highScores   // get_Name:    highScores   // getName->1:  highScores   // getName->2:  highScores   // getName->N:  highScores   // ofs = 52446 ord = 12 addr = 0
	bipush -1
	invokenonvirtual com.plazmic.rooster.HighScores.setRank // pc=2
	aload_0 
	bipush 4
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label116:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label129
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_103:"About"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label129
	aload_0 
	bipush 6
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label129:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label145
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_100:"Resume"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label145
	aload_0_getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	iconst_0 
	putfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	aload_0 
	iconst_1 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label145:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label161
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_47:"Pause"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label161
	aload_0_getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	iconst_1 
	putfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	aload_0 
	bipush 7
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label161:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label182
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_43:"Hide"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label182
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	bipush 5
	if_icmpeq Label179
	aload_0_getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	iconst_1 
	putfield .field_15_15   // get_name_1:  .field_15_15   // get_name_2:  .field_15_15   // get_Name:    .field_15_15   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 15
	aload_0 
	bipush 7
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
Label179:
	aload_0_getfield parent   // get_name_1:  parent   // get_name_2:  parent   // get_Name:    parent   // getName->1:  parent   // getName->2:  parent   // getName->N:  parent   // ofs = 52398 ord = 0 addr = 0
	invokevirtual notifyPaused( javax.microedition.midlet.MIDlet ) // pc=1
	return 
Label182:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label207
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_44:"New Game"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label207
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52470   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52470   // getName->1:     // getName->2:     // getName->N:     // ofs = 52470 ord = 18 addr = 0
	aload_0_getfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	iconst_1 
	invokenonvirtual com.plazmic.rooster.Confirm.setUsage // pc=2
	aload_0_getfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	iconst_1 
	invokenonvirtual com.plazmic.rooster.Confirm.setPreviousMode // pc=2
	aload_0 
	iconst_1 
	putfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	aload_0 
	bipush 8
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label207:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label220
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_104:"Start"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label220
	aload_0 
	iconst_1 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label220:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label233
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_94:"Continue"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label233
	aload_0 
	iconst_1 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label233:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 8
	if_icmpne Label245
	aload_1 
	invokevirtual getLabel( javax.microedition.lcdui.Command ) // pc=1
	ldc literal_63:"Toggle Death Buzz"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label245
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52438   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52438   // getName->1:     // getName->2:     // getName->N:     // ofs = 52438 ord = 10 addr = 0
	invokenonvirtual com.plazmic.rooster.KeyMapper.toggleDeathBuzz // pc=1
	return 
Label245:
	aload_1 
	invokevirtual getCommandType( javax.microedition.lcdui.Command ) // pc=1
	bipush 7
	if_icmpne Label258
	aload_0_getfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	bipush 2
	invokenonvirtual com.plazmic.rooster.Confirm.setUsage // pc=2
	aload_0_getfield confirm   // get_name_1:  confirm   // get_name_2:  confirm   // get_Name:    confirm   // getName->1:  confirm   // getName->2:  confirm   // getName->N:  confirm   // ofs = 52422 ord = 6 addr = 0
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52458   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52458   // getName->1:     // getName->2:     // getName->N:     // ofs = 52458 ord = 15 addr = 0
	invokenonvirtual com.plazmic.rooster.Confirm.setPreviousMode // pc=2
	aload_0 
	bipush 8
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
Label258:
	return 
	}


public final run( com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	xenter 
	aload_0 
	aload_0 
	invokevirtual getGraphics( javax.microedition.lcdui.game.GameCanvas ) // pc=1
	putfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	bipush 60
	istore_1 
	aload_0 
	iconst_0 
	putfield com.plazmic.rooster.RoosterCanvas.field_52454   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52454   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52454   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52454   // getName->1:     // getName->2:     // getName->N:     // ofs = 52454 ord = 14 addr = 0
	aload_0 
	invokevirtual repaint( javax.microedition.lcdui.Canvas ) // pc=1
	goto Label37
Label13:
	invokestatic_lib currentTimeMillis(  ) // 
	lstore 2
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	aload_0_getfield g   // get_name_1:  g   // get_name_2:  g   // get_Name:    g   // getName->1:  g   // getName->2:  g   // getName->N:  g   // ofs = 52474 ord = 19 addr = 0
	invokevirtual_short .virtual_3 // idx=3 pc=2
	invokestatic_lib currentTimeMillis(  ) // 
	lstore 4
	lload 4
	lload 2
	lsub 
	l2i 
	istore_6 
	iload_6 
	iload_1 
	if_icmpge Label35
	iload_1 
	iload_6 
	isub 
	i2l 
	invokestatic_lib sleep( long ) // 
	goto Label35
	astore_7 
Label35:
	aload_0 
	invokevirtual flushGraphics( javax.microedition.lcdui.game.GameCanvas ) // pc=1
Label37:
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52454   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52454   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52454   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52454   // getName->1:     // getName->2:     // getName->N:     // ofs = 52454 ord = 14 addr = 0
	ifeq Label13
	return 
	}


protected final keyReleased( com.plazmic.rooster.RoosterCanvas, int ); // address: 0
	{
	enter_narrow 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	iload_1 
	invokevirtual_short .virtual_5 // idx=5 pc=2
	return 
	}


protected final keyPressed( com.plazmic.rooster.RoosterCanvas, int ); // address: 0
	{
	enter_narrow 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	iload_1 
	invokevirtual_short .virtual_4 // idx=4 pc=2
	return 
	}


public final paint( com.plazmic.rooster.RoosterCanvas, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_1 
	aload_0_getfield TRANSLATEX   // get_name_1:  TRANSLATEX   // get_name_2:  TRANSLATEX   // get_Name:    TRANSLATEX   // getName->1:  TRANSLATEX   // getName->2:  TRANSLATEX   // getName->N:  TRANSLATEX   // ofs = 52462 ord = 16 addr = 0
	aload_0_getfield TRANSLATEY   // get_name_1:  TRANSLATEY   // get_name_2:  TRANSLATEY   // get_Name:    TRANSLATEY   // getName->1:  TRANSLATEY   // getName->2:  TRANSLATEY   // getName->N:  TRANSLATEY   // ofs = 52466 ord = 17 addr = 0
	invokevirtual translate( javax.microedition.lcdui.Graphics, int, int ) // pc=3
	invokestatic_lib getDeviceName(  ) // 
	ldc literal_21:"71"
	invokenonvirtual_lib java.lang.String.startsWith // pc=2
	ifeq Label22
	aload_1 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52490   // getName->1:     // getName->2:     // getName->N:     // ofs = 52490 ord = 23 addr = 0
	iconst_0 
	iconst_0 
	bipush 36
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52494   // getName->1:     // getName->2:     // getName->N:     // ofs = 52494 ord = 24 addr = 0
	iconst_0 
	sipush 160
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	goto Label61
Label22:
	invokestatic_lib getDeviceName(  ) // 
	ldc literal_105:"87"
	invokenonvirtual_lib java.lang.String.startsWith // pc=2
	ifeq Label61
	aload_1 
	iipush 13226452
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	bipush -40
	iconst_0 
	aload_0 
	invokevirtual getWidth( javax.microedition.lcdui.Displayable ) // pc=1
	aload_0 
	invokevirtual getHeight( javax.microedition.lcdui.Displayable ) // pc=1
	invokevirtual fillRect( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52490   // getName->1:     // getName->2:     // getName->N:     // ofs = 52490 ord = 23 addr = 0
	bipush -40
	iconst_0 
	bipush 36
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52490   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52490   // getName->1:     // getName->2:     // getName->N:     // ofs = 52490 ord = 23 addr = 0
	sipush 200
	iconst_0 
	bipush 36
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52494   // getName->1:     // getName->2:     // getName->N:     // ofs = 52494 ord = 24 addr = 0
	bipush -40
	sipush 160
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52494   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52494   // getName->1:     // getName->2:     // getName->N:     // ofs = 52494 ord = 24 addr = 0
	sipush 200
	sipush 160
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
Label61:
	aload_1 
	iconst_0 
	iconst_0 
	sipush 240
	sipush 160
	invokevirtual setClip( javax.microedition.lcdui.Graphics, int, int, int, int ) // pc=5
	aload_0_getfield com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_1:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_name_2:  com.plazmic.rooster.RoosterCanvas.field_52450   // get_Name:    com.plazmic.rooster.RoosterCanvas.field_52450   // getName->1:     // getName->2:     // getName->N:     // ofs = 52450 ord = 13 addr = 0
	aload_1 
	invokevirtual_short .virtual_3 // idx=3 pc=2
	return 
	}

}
