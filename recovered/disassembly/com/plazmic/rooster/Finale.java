// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 4
// ########################################################


package com.plazmic.rooster;


abstract final class Finale extends com.plazmic.rooster.Mode

{
	// @@@@@@@@@@@@@ Static fields 
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_50610 ; // ofs = 50610 addr = 16)

	// @@@@@@@@@@@@@ Fields 
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_50578 ; // ofs = 50578 addr = 0)
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_50582 ; // ofs = 50582 addr = 0)
	private int /*int*/  field_50586 ; // ofs = 50586 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50590 ; // ofs = 50590 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50594 ; // ofs = 50594 addr = 0)
	private javax.microedition.lcdui.Image /*javax.microedition.lcdui.Image*/  field_50598 ; // ofs = 50598 addr = 0)
	private int /*int*/  field_50602 ; // ofs = 50602 addr = 0)
	private int /*int*/  field_50606 ; // ofs = 50606 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.Finale, com.plazmic.rooster.RoosterCanvas, com.plazmic.rooster.Loading, javax.microedition.lcdui.Graphics ); // address: 0
	{
	xenter 
	aload_0 
	invokespecial com.plazmic.rooster.Mode.<init> // pc=1
	aload_0 
	iconst_0 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	aload_1 
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_17:"Start Screen"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_2 
	invokenonvirtual com.plazmic.rooster.Loading.reset // pc=1
	aload_2 
	bipush 2
	invokenonvirtual com.plazmic.rooster.Loading.setBarIncrements // pc=2
	aload_2 
	ldc literal_26:"Loading BackGround"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	aload_2 
	aload_3 
	invokevirtual_short .virtual_3 // idx=3 pc=2
	aload_0 
	ldc literal_27:"img/winGold.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	ldc literal_28:"img/winGold_finish.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_2 
	ldc literal_29:"Loading Text"
	invokenonvirtual com.plazmic.rooster.Loading.setMessage // pc=2
	aload_2 
	aload_3 
	invokevirtual_short .virtual_3 // idx=3 pc=2
	aload_0 
	ldc literal_30:"img/winGold_txt.png"
	invokestatic_lib createImage( java.lang.String ) // 
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	goto Label53
	astore_4 
	getstatic_lib out // System
	ldc literal_31:"Could not find one of the splash images.  "
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	aload_4 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
Label53:
	aload_0 
	invokenonvirtual com.plazmic.rooster.Finale.reset // pc=1
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit Mode
	synch_static Finale
	clinit_wait 
	iconst_0 
	iconst_1 
	bipush 8
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.Finale.field_50610 // Finale
	clinit_return 
	}

	// @@@@@@@@@@@@@ Non-virtual routines 

public final reset( com.plazmic.rooster.Finale ); // address: 0
	{
	enter_narrow 
	aload_0 
	iconst_0 
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	aload_0 
	bipush 10
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final keyPressed( com.plazmic.rooster.Finale, int ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.getScore // pc=1
	invokestatic int isInTopTen( int ) // Storage
	istore_2 
	iload_2 
	bipush -1
	if_icmple Label22
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	getfield enterName   // get_name_1:  enterName   // get_name_2:  enterName   // get_Name:    enterName   // getName->1:  enterName   // getName->2:  enterName   // getName->N:  enterName   // ofs = 52434 ord = 9 addr = 0
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	getfield .field_14_14   // get_name_1:  .field_14_14   // get_name_2:  .field_14_14   // get_Name:    .field_14_14   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 14
	invokenonvirtual com.plazmic.rooster.HUD.getScore // pc=1
	iload_2 
	invokenonvirtual com.plazmic.rooster.EnterName.setHighScoreInfo // pc=3
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	bipush 2
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
Label22:
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	iconst_0 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.switchToMode // pc=2
	return 
	}


public final keyReleased( com.plazmic.rooster.Finale, int ); // address: 0
	{
	noenter_return 
	}


public final render( com.plazmic.rooster.Finale, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	bipush 60
	if_icmple Label15
	aload_0 
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	sipush -215
	if_icmple Label12
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	iconst_1 
	isub 
	goto Label13
Label12:
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
Label13:
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	goto Label20
Label15:
	aload_0 
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	iconst_1 
	iadd 
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
Label20:
	aload_1 
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	iconst_0 
	iconst_0 
	bipush 20
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_1 
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	sipush 240
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	bipush 24
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	sipush -215
	if_icmpne Label60
	aload_0 
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	iconst_1 
	iadd 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	bipush 4
	if_icmpge Label44
	return 
Label44:
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	bipush 4
	if_icmplt Label57
	aload_0_getfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	bipush 12
	if_icmpge Label57
	aload_1 
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	sipush 178
	sipush 130
	bipush 3
	invokevirtual drawImage( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int ) // pc=5
	return 
Label57:
	aload_0 
	iconst_0 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
Label60:
	return 
	}


public final setMenu( com.plazmic.rooster.Finale ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}


public final unsetMenu( com.plazmic.rooster.Finale ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}

}
