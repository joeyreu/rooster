// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 23
// ########################################################


package com.plazmic.rooster;


abstract final class Storage extends Object

{
	// @@@@@@@@@@@@@ Static fields 
	public static byte[] /*byte[]*/  charMapping ; // ofs = 52938 addr = 86)
	public static byte[] /*byte[]*/  scoresdata ; // ofs = 52944 addr = 87)


	// @@@@@@@@@@@@@ Static routines 

public final <init>( com.plazmic.rooster.Storage ); // address: 0
	{
	xenter 
	aload_0 
	invokespecial_lib java.lang.Object.<init> // pc=1
	op01xx 
	stringarrayinit [S Q, TAW, CCC, DDD, EEE, FFF, GGG, HHH, III, JJJ]
	astore_1 
	bipush 7
	newarray 2
	astore_3 
	invokestatic byte[] getMapping(  ) // Storage
	putstatic charMapping // Storage
	ldc literal_124:"Scores"
	iconst_1 
	invokestatic_lib openRecordStore( java.lang.String, boolean ) // 
	astore_5 
	aload_5 
	invokevirtual getNumRecords( javax.microedition.rms.RecordStore ) // pc=1
	ifne Label94
	iconst_0 
	istore_6 
	goto Label91
Label21:
	bipush 10
	iload_6 
	isub 
	bipush 20
	imul 
	istore_4 
	aload_3 
	iconst_0 
	iload_4 
	bipush 24
	iushr 
	i2b 
	bastore 
	aload_3 
	iconst_1 
	iload_4 
	bipush 16
	iushr 
	sipush 255
	iand 
	i2b 
	bastore 
	aload_3 
	bipush 2
	iload_4 
	bipush 8
	iushr 
	sipush 255
	iand 
	i2b 
	bastore 
	aload_3 
	bipush 3
	iload_4 
	iconst_0 
	iushr 
	sipush 255
	iand 
	i2b 
	bastore 
	aload_1 
	iload_6 
	aaload 
	invokenonvirtual_lib java.lang.String.getBytes // pc=1
	astore_2 
	aload_3 
	bipush 4
	aload_2 
	iconst_0 
	baload 
	bastore 
	aload_3 
	bipush 5
	aload_2 
	iconst_1 
	baload 
	bastore 
	aload_3 
	bipush 6
	aload_2 
	bipush 2
	baload 
	bastore 
	aload_5 
	aload_3 
	iconst_0 
	bipush 7
	invokevirtual addRecord( javax.microedition.rms.RecordStore, byte[], int, int ) // pc=4
	pop 
	iinc 6 1
Label91:
	iload_6 
	bipush 10
	if_icmplt Label21
Label94:
	aload_5 
	invokevirtual closeRecordStore( javax.microedition.rms.RecordStore ) // pc=1
	return 
	astore_5 
	getstatic_lib out // System
	ldc literal_125:"Record store was not opened for reading."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	aload_5 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
	return 
	}


static public final byte[] getMapping(  ); // address: 0
	{
	xenter 
	arrayinit [87, 76, 83, 75]
	astore_0 
	invokestatic_lib getDeviceName(  ) // 
	ldc literal_21:"71"
	invokenonvirtual_lib java.lang.String.startsWith // pc=2
	ifeq Label32
	aload_0 
	iconst_0 
	bipush 81
	bastore 
	aload_0 
	iconst_1 
	bipush 76
	bastore 
	aload_0 
	bipush 2
	bipush 65
	bastore 
	invokestatic_lib getPlatformVersion(  ) // 
	ldc literal_20:"1.8"
	invokenonvirtual_lib java.lang.String.startsWith // pc=2
	ifeq Label28
	aload_0 
	bipush 3
	bipush 74
	bastore 
	goto Label32
Label28:
	aload_0 
	bipush 3
	bipush 54
	bastore 
Label32:
	ldc literal_126:"Key Mappings"
	iconst_1 
	invokestatic_lib openRecordStore( java.lang.String, boolean ) // 
	astore_1 
	aload_1 
	aconst_null 
	aconst_null 
	iconst_0 
	invokevirtual enumerateRecords( javax.microedition.rms.RecordStore, javax.microedition.rms.RecordFilter, javax.microedition.rms.RecordComparator, boolean ) // pc=4
	astore_2 
	aload_2 
	invokeinterface interfacemethodref_2 // pc=1 guess=0
	ifeq Label48
	aload_2 
	invokeinterface interfacemethodref_3 // pc=1 guess=1
	astore_0 
Label48:
	aload_1 
	invokevirtual closeRecordStore( javax.microedition.rms.RecordStore ) // pc=1
	goto Label57
	astore_1 
	getstatic_lib out // System
	ldc literal_125:"Record store was not opened for reading."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	aload_1 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
Label57:
	aload_0 
	putstatic charMapping // Storage
	aload_0 
	areturn 
	}


static public final setMapping( byte[] ); // address: 0
	{
	xenter 
	ldc literal_126:"Key Mappings"
	iconst_1 
	invokestatic_lib openRecordStore( java.lang.String, boolean ) // 
	astore_1 
	aload_1 
	aconst_null 
	aconst_null 
	iconst_0 
	invokevirtual enumerateRecords( javax.microedition.rms.RecordStore, javax.microedition.rms.RecordFilter, javax.microedition.rms.RecordComparator, boolean ) // pc=4
	astore_2 
	aload_2 
	invokeinterface interfacemethodref_2 // pc=1 guess=2
	ifeq Label20
	aload_2 
	invokeinterface interfacemethodref_4 // pc=1 guess=3
	istore_3 
	aload_1 
	iload_3 
	invokevirtual deleteRecord( javax.microedition.rms.RecordStore, int ) // pc=2
Label20:
	aload_1 
	aload_0 
	iconst_0 
	bipush 4
	invokevirtual addRecord( javax.microedition.rms.RecordStore, byte[], int, int ) // pc=4
	pop 
	aload_0 
	putstatic charMapping // Storage
	aload_1 
	invokevirtual closeRecordStore( javax.microedition.rms.RecordStore ) // pc=1
	return 
	astore_1 
	getstatic_lib out // System
	ldc literal_127:"Record store was not opened for writing."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}


static public final boolean getDeathBuzz(  ); // address: 0
	{
	xenter 
	iconst_1 
	istore_0 
	bipush -1
	istore_2 
	ldc literal_128:"DeathBuzz"
	iconst_0 
	invokestatic_lib openRecordStore( java.lang.String, boolean ) // 
	astore_3 
	aload_3 
	aconst_null 
	aconst_null 
	iconst_0 
	invokevirtual enumerateRecords( javax.microedition.rms.RecordStore, javax.microedition.rms.RecordFilter, javax.microedition.rms.RecordComparator, boolean ) // pc=4
	astore_4 
	aload_4 
	invokeinterface interfacemethodref_2 // pc=1 guess=4
	ifeq Label21
	aload_4 
	invokeinterface interfacemethodref_4 // pc=1 guess=5
	istore_2 
Label21:
	aload_3 
	iload_2 
	invokevirtual getRecord( javax.microedition.rms.RecordStore, int ) // pc=2
	iconst_0 
	baload 
	bipush 121
	if_icmpne Label30
	iconst_1 
	goto Label31
Label30:
	iconst_0 
Label31:
	istore_0 
	iload_0 
	ireturn 
	astore_3 
	aload_3 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
	getstatic_lib out // System
	ldc literal_129:"DeathBuzz record store was not opened for reading."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	iload_0 
	ireturn 
	}


static public final boolean toggleDeathBuzz(  ); // address: 0
	{
	xenter 
	invokestatic boolean getDeathBuzz(  ) // Storage
	ifne Label5
	iconst_1 
	goto Label6
Label5:
	iconst_0 
Label6:
	istore_0 
	iconst_1 
	newarray 2
	dup 
	iconst_0 
	iload_0 
	ifeq Label15
	bipush 121
	goto Label16
Label15:
	bipush 110
Label16:
	bastore 
	astore_1 
	bipush -1
	istore_2 
	ldc literal_128:"DeathBuzz"
	iconst_1 
	invokestatic_lib openRecordStore( java.lang.String, boolean ) // 
	astore_3 
	aload_3 
	aconst_null 
	aconst_null 
	iconst_0 
	invokevirtual enumerateRecords( javax.microedition.rms.RecordStore, javax.microedition.rms.RecordFilter, javax.microedition.rms.RecordComparator, boolean ) // pc=4
	astore_4 
	aload_4 
	invokeinterface interfacemethodref_2 // pc=1 guess=6
	ifeq Label36
	aload_4 
	invokeinterface interfacemethodref_4 // pc=1 guess=7
	istore_2 
Label36:
	iload_2 
	bipush -1
	if_icmpeq Label46
	aload_3 
	iload_2 
	aload_1 
	iconst_0 
	iconst_1 
	invokevirtual setRecord( javax.microedition.rms.RecordStore, int, byte[], int, int ) // pc=5
	goto Label60
Label46:
	aload_3 
	aload_1 
	iconst_0 
	iconst_1 
	invokevirtual addRecord( javax.microedition.rms.RecordStore, byte[], int, int ) // pc=4
	pop 
	iload_0 
	ireturn 
	astore_3 
	aload_3 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
	getstatic_lib out // System
	ldc literal_130:"DeathBuzz record store was not opened for writing."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
Label60:
	iload_0 
	ireturn 
	}


static public final byte[] resetMapping(  ); // address: 0
	{
	enter_narrow 
	arrayinit [87, 76, 83, 75]
	astore_0 
	invokestatic_lib getDeviceName(  ) // 
	ldc literal_21:"71"
	invokenonvirtual_lib java.lang.String.startsWith // pc=2
	ifeq Label23
	aload_0 
	iconst_0 
	bipush 81
	bastore 
	aload_0 
	iconst_1 
	bipush 76
	bastore 
	aload_0 
	bipush 2
	bipush 65
	bastore 
	aload_0 
	bipush 3
	bipush 54
	bastore 
Label23:
	ldc literal_126:"Key Mappings"
	invokestatic_lib deleteRecordStore( java.lang.String ) // 
	goto Label27
	astore_1 
Label27:
	aload_0 
	putstatic charMapping // Storage
	aload_0 
	areturn 
	}


static public final byte[] getHighScores(  ); // address: 0
	{
	xenter 
	bipush 70
	newarray 2
	astore_0 
	iconst_0 
	istore_1 
	ldc literal_124:"Scores"
	iconst_1 
	invokestatic_lib openRecordStore( java.lang.String, boolean ) // 
	astore_3 
	aload_3 
	aconst_null 
	aconst_null 
	iconst_0 
	invokevirtual enumerateRecords( javax.microedition.rms.RecordStore, javax.microedition.rms.RecordFilter, javax.microedition.rms.RecordComparator, boolean ) // pc=4
	astore_4 
	goto Label73
Label17:
	aload_4 
	invokeinterface interfacemethodref_4 // pc=1 guess=8
	istore_5 
	aload_3 
	iload_5 
	invokevirtual getRecord( javax.microedition.rms.RecordStore, int ) // pc=2
	astore_2 
	aload_0 
	iload_1 
	iinc 1 1
	aload_2 
	iconst_0 
	baload 
	bastore 
	aload_0 
	iload_1 
	iinc 1 1
	aload_2 
	iconst_1 
	baload 
	bastore 
	aload_0 
	iload_1 
	iinc 1 1
	aload_2 
	bipush 2
	baload 
	bastore 
	aload_0 
	iload_1 
	iinc 1 1
	aload_2 
	bipush 3
	baload 
	bastore 
	aload_0 
	iload_1 
	iinc 1 1
	aload_2 
	bipush 4
	baload 
	bastore 
	aload_0 
	iload_1 
	iinc 1 1
	aload_2 
	bipush 5
	baload 
	bastore 
	aload_0 
	iload_1 
	iinc 1 1
	aload_2 
	bipush 6
	baload 
	bastore 
Label73:
	aload_4 
	invokeinterface interfacemethodref_2 // pc=1 guess=9
	ifne Label17
	aload_3 
	invokevirtual closeRecordStore( javax.microedition.rms.RecordStore ) // pc=1
	aload_0 
	areturn 
	astore_3 
	getstatic_lib out // System
	ldc literal_125:"Record store was not opened for reading."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	aload_3 
	invokevirtual printStackTrace( java.lang.Throwable ) // pc=1
	aload_0 
	areturn 
	}


static public final int isInTopTen( int ); // address: 0
	{
	enter 
	invokestatic byte[] getHighScores(  ) // Storage
	astore_1 
	iconst_0 
	istore_3 
	goto Label58
Label6:
	aload_1 
	iload_3 
	bipush 7
	imul 
	iconst_0 
	iadd 
	baload 
	sipush 255
	iand 
	bipush 24
	ishl 
	aload_1 
	iload_3 
	bipush 7
	imul 
	iconst_1 
	iadd 
	baload 
	sipush 255
	iand 
	bipush 16
	ishl 
	ior 
	aload_1 
	iload_3 
	bipush 7
	imul 
	bipush 2
	iadd 
	baload 
	sipush 255
	iand 
	bipush 8
	ishl 
	ior 
	aload_1 
	iload_3 
	bipush 7
	imul 
	bipush 3
	iadd 
	baload 
	sipush 255
	iand 
	ior 
	istore_2 
	iload_0 
	iload_2 
	if_icmple Label57
	iload_3 
	ireturn 
Label57:
	iinc 3 1
Label58:
	iload_3 
	bipush 10
	if_icmplt Label6
	bipush -1
	ireturn 
	}


static public final setHighScore( int, byte[], int ); // address: 0
	{
	xenter 
	bipush 7
	newarray 2
	astore_3 
	bipush 7
	newarray 2
	astore_4 
	iconst_0 
	istore_5 
	aload_3 
	iconst_0 
	iload_2 
	bipush 24
	iushr 
	i2b 
	bastore 
	aload_3 
	iconst_1 
	iload_2 
	bipush 16
	iushr 
	sipush 255
	iand 
	i2b 
	bastore 
	aload_3 
	bipush 2
	iload_2 
	bipush 8
	iushr 
	sipush 255
	iand 
	i2b 
	bastore 
	aload_3 
	bipush 3
	iload_2 
	iconst_0 
	iushr 
	sipush 255
	iand 
	i2b 
	bastore 
	aload_3 
	bipush 4
	aload_1 
	iconst_0 
	baload 
	bastore 
	aload_3 
	bipush 5
	aload_1 
	iconst_1 
	baload 
	bastore 
	aload_3 
	bipush 6
	aload_1 
	bipush 2
	baload 
	bastore 
	ldc literal_124:"Scores"
	iconst_1 
	invokestatic_lib openRecordStore( java.lang.String, boolean ) // 
	astore_6 
	aload_6 
	aconst_null 
	aconst_null 
	iconst_0 
	invokevirtual enumerateRecords( javax.microedition.rms.RecordStore, javax.microedition.rms.RecordFilter, javax.microedition.rms.RecordComparator, boolean ) // pc=4
	astore_7 
	goto Label149
Label72:
	aload_7 
	invokeinterface interfacemethodref_4 // pc=1 guess=10
	istore 8
	iload_5 
	iload_0 
	if_icmpne Label91
	aload_6 
	iload 8
	aload_4 
	iconst_0 
	invokevirtual getRecord( javax.microedition.rms.RecordStore, int, byte[], int ) // pc=4
	pop 
	aload_6 
	iload 8
	aload_3 
	iconst_0 
	bipush 7
	invokevirtual setRecord( javax.microedition.rms.RecordStore, int, byte[], int, int ) // pc=5
	goto Label148
Label91:
	iload_5 
	iload_0 
	if_icmple Label148
	aload_3 
	iconst_0 
	aload_4 
	iconst_0 
	baload 
	bastore 
	aload_3 
	iconst_1 
	aload_4 
	iconst_1 
	baload 
	bastore 
	aload_3 
	bipush 2
	aload_4 
	bipush 2
	baload 
	bastore 
	aload_3 
	bipush 3
	aload_4 
	bipush 3
	baload 
	bastore 
	aload_3 
	bipush 4
	aload_4 
	bipush 4
	baload 
	bastore 
	aload_3 
	bipush 5
	aload_4 
	bipush 5
	baload 
	bastore 
	aload_3 
	bipush 6
	aload_4 
	bipush 6
	baload 
	bastore 
	aload_6 
	iload 8
	aload_4 
	iconst_0 
	invokevirtual getRecord( javax.microedition.rms.RecordStore, int, byte[], int ) // pc=4
	pop 
	aload_6 
	iload 8
	aload_3 
	iconst_0 
	bipush 7
	invokevirtual setRecord( javax.microedition.rms.RecordStore, int, byte[], int, int ) // pc=5
Label148:
	iinc 5 1
Label149:
	aload_7 
	invokeinterface interfacemethodref_2 // pc=1 guess=11
	ifne Label72
	aload_6 
	invokevirtual closeRecordStore( javax.microedition.rms.RecordStore ) // pc=1
	return 
	astore_6 
	getstatic_lib out // System
	ldc literal_127:"Record store was not opened for writing."
	invokevirtual println( java.io.PrintStream, java.lang.String ) // pc=2
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	synch_static Storage
	clinit_wait 
	bipush 4
	newarray 2
	putstatic charMapping // Storage
	bipush 40
	newarray 2
	putstatic scoresdata // Storage
	clinit_return 
	}

}
