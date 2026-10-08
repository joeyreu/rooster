// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 20
// ########################################################


package com.plazmic.rooster;


abstract public final class RoosterMIDlet extends javax.microedition.midlet.MIDlet

{

	// @@@@@@@@@@@@@ Fields 
	private com.plazmic.rooster.RoosterCanvas /*com.plazmic.rooster.RoosterCanvas*/  field_52582 ; // ofs = 52582 addr = 0)

	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.RoosterMIDlet ); // address: 0
	{
	jumpspecial_lib <init>( javax.microedition.midlet.MIDlet )
	}

	// @@@@@@@@@@@@@ Virtual routines 

protected final startApp( com.plazmic.rooster.RoosterMIDlet ); // address: 0
	{
	enter_narrow 
	aload_0_getfield com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_1:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_2:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_Name:    com.plazmic.rooster.RoosterMIDlet.field_52582   // getName->1:     // getName->2:     // getName->N:     // ofs = 52582 ord = 0 addr = 0
	ifnonnull Label8
	aload_0 
	new RoosterCanvas
	dup 
	invokespecial com.plazmic.rooster.RoosterCanvas.<init> // pc=1
	putfield com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_1:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_2:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_Name:    com.plazmic.rooster.RoosterMIDlet.field_52582   // getName->1:     // getName->2:     // getName->N:     // ofs = 52582 ord = 0 addr = 0
Label8:
	aload_0 
	invokestatic_lib getDisplay( javax.microedition.midlet.MIDlet ) // 
	aload_0_getfield com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_1:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_2:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_Name:    com.plazmic.rooster.RoosterMIDlet.field_52582   // getName->1:     // getName->2:     // getName->N:     // ofs = 52582 ord = 0 addr = 0
	invokevirtual setCurrent( javax.microedition.lcdui.Display, javax.microedition.lcdui.Displayable ) // pc=2
	aload_0_getfield com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_1:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_2:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_Name:    com.plazmic.rooster.RoosterMIDlet.field_52582   // getName->1:     // getName->2:     // getName->N:     // ofs = 52582 ord = 0 addr = 0
	aload_0 
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.setParent // pc=2
	new_lib Thread//java.lang.Thread java.lang.Thread java.lang.Thread
	dup 
	aload_0_getfield com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_1:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_2:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_Name:    com.plazmic.rooster.RoosterMIDlet.field_52582   // getName->1:     // getName->2:     // getName->N:     // ofs = 52582 ord = 0 addr = 0
	invokespecial_lib java.lang.Thread.<init> // pc=2
	astore_1 
	aload_1 
	invokevirtual start( java.lang.Thread ) // pc=1
	return 
	}


protected final pauseApp( com.plazmic.rooster.RoosterMIDlet ); // address: 0
	{
	enter_narrow 
	aload_0_getfield com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_1:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_2:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_Name:    com.plazmic.rooster.RoosterMIDlet.field_52582   // getName->1:     // getName->2:     // getName->N:     // ofs = 52582 ord = 0 addr = 0
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.terminate // pc=1
	return 
	}


protected final destroyApp( com.plazmic.rooster.RoosterMIDlet, boolean ); // address: 0
	{
	enter_narrow 
	aload_0_getfield com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_1:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_name_2:  com.plazmic.rooster.RoosterMIDlet.field_52582   // get_Name:    com.plazmic.rooster.RoosterMIDlet.field_52582   // getName->1:     // getName->2:     // getName->N:     // ofs = 52582 ord = 0 addr = 0
	invokenonvirtual com.plazmic.rooster.RoosterCanvas.terminate // pc=1
	return 
	}

}
