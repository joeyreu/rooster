// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 17
// ########################################################


package com.plazmic.rooster;


abstract final class Pause extends com.plazmic.rooster.Mode

{
	// @@@@@@@@@@@@@ Static fields 
	private static javax.microedition.lcdui.Font /*javax.microedition.lcdui.Font*/  field_52196 ; // ofs = 52196 addr = 71)

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_52156 ; // ofs = 52156 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_52160 ; // ofs = 52160 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_52164 ; // ofs = 52164 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_52168 ; // ofs = 52168 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_52172 ; // ofs = 52172 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_52176 ; // ofs = 52176 addr = 0)
	private javax.microedition.lcdui.Command /*javax.microedition.lcdui.Command*/  field_52180 ; // ofs = 52180 addr = 0)
	private int /*int*/  field_52184 ; // ofs = 52184 addr = 0)
	private int /*int*/  field_52188 ; // ofs = 52188 addr = 0)
	private boolean /*boolean*/  field_52192 ; // ofs = 52192 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.Pause, com.plazmic.rooster.RoosterCanvas ); // address: 0
	{
	enter 
	aload_0 
	invokespecial com.plazmic.rooster.Mode.<init> // pc=1
	aload_0 
	iconst_0 
	putfield .field_7_7   // get_name_1:  .field_7_7   // get_name_2:  .field_7_7   // get_Name:    .field_7_7   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 7
	aload_0 
	bipush 30
	putfield .field_8_8   // get_name_1:  .field_8_8   // get_name_2:  .field_8_8   // get_Name:    .field_8_8   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 8
	aload_0 
	iconst_0 
	putfield .field_9_9   // get_name_1:  .field_9_9   // get_name_2:  .field_9_9   // get_Name:    .field_9_9   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 9
	aload_0 
	aload_1 
	putfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_43:"Hide"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_44:"New Game"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_45:"Settings"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_46:"Quit Game"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_100:"Resume"
	bipush 8
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	aload_0 
	new_lib javax.microedition.lcdui.Command//javax.microedition.lcdui.Command javax.microedition.lcdui.Command javax.microedition.lcdui.Command
	dup 
	ldc literal_48:"Close"
	bipush 7
	iconst_1 
	invokespecial_lib javax.microedition.lcdui.Command.<init> // pc=4
	putfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit Mode
	synch_static Pause
	clinit_wait 
	iconst_0 
	iconst_1 
	bipush 16
	invokestatic_lib getFont( int, int, int ) // 
	putstatic com.plazmic.rooster.Pause.field_52196 // Pause
	clinit_return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final keyPressed( com.plazmic.rooster.Pause, int ); // address: 0
	{
	noenter_return 
	}


public final keyReleased( com.plazmic.rooster.Pause, int ); // address: 0
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
	return 
	}


public final render( com.plazmic.rooster.Pause, javax.microedition.lcdui.Graphics ); // address: 0
	{
	enter 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	getfield game   // get_name_1:  game   // get_name_2:  game   // get_Name:    game   // getName->1:  game   // getName->2:  game   // getName->N:  game   // ofs = 52442 ord = 11 addr = 0
	aload_1 
	invokevirtual_short .virtual_3 // idx=3 pc=2
	aload_1 
	getstatic com.plazmic.rooster.Pause.field_52196 // Pause
	invokevirtual setFont( javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Font ) // pc=2
	aload_1 
	iipush 7798784
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	ldc literal_99:"Paused"
	bipush 119
	bipush 72
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	ldc literal_99:"Paused"
	bipush 121
	bipush 72
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	ldc literal_99:"Paused"
	bipush 119
	bipush 74
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	ldc literal_99:"Paused"
	bipush 121
	bipush 74
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	aload_1 
	iipush 16777215
	invokevirtual setColor( javax.microedition.lcdui.Graphics, int ) // pc=2
	aload_1 
	ldc literal_99:"Paused"
	bipush 120
	bipush 73
	bipush 17
	invokevirtual drawString( javax.microedition.lcdui.Graphics, java.lang.String, int, int, int ) // pc=5
	return 
	}


public final setMenu( com.plazmic.rooster.Pause ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	invokevirtual addCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}


public final unsetMenu( com.plazmic.rooster.Pause ); // address: 0
	{
	enter_narrow 
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_1_1   // get_name_1:  .field_1_1   // get_name_2:  .field_1_1   // get_Name:    .field_1_1   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 1
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_2_2   // get_name_1:  .field_2_2   // get_name_2:  .field_2_2   // get_Name:    .field_2_2   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 2
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_3_3   // get_name_1:  .field_3_3   // get_name_2:  .field_3_3   // get_Name:    .field_3_3   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 3
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_4_4   // get_name_1:  .field_4_4   // get_name_2:  .field_4_4   // get_Name:    .field_4_4   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 4
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_5_5   // get_name_1:  .field_5_5   // get_name_2:  .field_5_5   // get_Name:    .field_5_5   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 5
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	aload_0_getfield .field_0_   // get_name_1:  .field_0_   // get_name_2:  .field_0_   // get_Name:    .field_0_   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 0
	aload_0_getfield .field_6_6   // get_name_1:  .field_6_6   // get_name_2:  .field_6_6   // get_Name:    .field_6_6   // getName->1:  null   // getName->2:  null   // getName->N:  null   // ofs = -1 ord = 0 addr = 6
	invokevirtual removeCommand( javax.microedition.lcdui.Displayable, javax.microedition.lcdui.Command ) // pc=2
	return 
	}

}
