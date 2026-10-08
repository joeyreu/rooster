// #######################################################
// Decompiled by   : coddec 
// Module          : com_plazmic_games_rooster.cod
// Module version  : 1.0.0.64
// Class ID        : 27
// ########################################################


package com.rim.resources;


abstract public final class com_plazmic_games_roosterRIMResources extends net.rim.device.resources.Resource

{
	// @@@@@@@@@@@@@ Static fields 
	public static java.util.Hashtable /*java.util.Hashtable*/  _resources ; // ofs = 53282 addr = 98)
	public static java.util.Hashtable /*java.util.Hashtable*/  _properties ; // ofs = 53288 addr = 99)
	public static byte[] /*byte[]*/  _appIcons ; // ofs = 53294 addr = 100)
	public static byte[] /*byte[]*/  _appCount ; // ofs = 53300 addr = 101)
	public static byte[] /*byte[]*/  _appNames ; // ofs = 53306 addr = 102)
	public static byte[] /*byte[]*/  _appArgs ; // ofs = 53312 addr = 103)
	public static byte[] /*byte[]*/  _appFlags ; // ofs = 53318 addr = 104)
	public static byte[] /*byte[]*/  _manifestVersion ; // ofs = 53324 addr = 105)
	public static byte[] /*byte[]*/  _midletJarSize ; // ofs = 53330 addr = 106)
	public static byte[] /*byte[]*/  _url ; // ofs = 53336 addr = 107)
	public static byte[] /*byte[]*/  _midletConfiguration ; // ofs = 53342 addr = 108)
	public static byte[] /*byte[]*/  _version ; // ofs = 53348 addr = 109)
	public static byte[] /*byte[]*/  _midletName ; // ofs = 53354 addr = 110)
	public static byte[] /*byte[]*/  _description ; // ofs = 53360 addr = 111)
	public static byte[] /*byte[]*/  _vendor ; // ofs = 53366 addr = 112)
	public static byte[] /*byte[]*/  _midletProfile ; // ofs = 53372 addr = 113)
	public static byte[] /*byte[]*/  _manifest ; // ofs = 53378 addr = 114)


	// @@@@@@@@@@@@@ Static routines 

public <init>( com.rim.resources.com_plazmic_games_roosterRIMResources ); // address: 0
	{
	enter 
	aload_0 
	getstatic _resources // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	getstatic _appIcons // com_plazmic_games_roosterRIMResources
	invokespecial_lib net.rim.device.resources.Resource.<init> // pc=4
	return 
	}


static final <clinit>(  ); // address: 0
	{
	enter 
	clinit_lib net.rim.device.resources.Resource//net.rim.device.resources.Resource net.rim.device.resources.Resource net.rim.device.resources.Resource
	synch_static com_plazmic_games_roosterRIMResources
	clinit_wait 
	new_lib java.util.Hashtable//java.util.Hashtable java.util.Hashtable java.util.Hashtable
	dup 
	bipush 127
	invokespecial_lib java.util.Hashtable.<init> // pc=2
	putstatic _resources // com_plazmic_games_roosterRIMResources
	new_lib java.util.Hashtable//java.util.Hashtable java.util.Hashtable java.util.Hashtable
	dup 
	bipush 30
	invokespecial_lib java.util.Hashtable.<init> // pc=2
	putstatic _properties // com_plazmic_games_roosterRIMResources
	arrayinit [1]
	putstatic _appCount // com_plazmic_games_roosterRIMResources
	arrayinit [0, 7, 82, 111, 111, 115, 116, 101, 114]
	putstatic _appNames // com_plazmic_games_roosterRIMResources
	arrayinit [5, -88, 5, -90, -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 36, 0, 0, 0, 36, 8, 3, 0, 0, 0, -42, -34, 104, -86, 0, 0, 2, 76, 80, 76, 84, 69, 99, 77, 0, 99, 81, 0, 107, 89, 0, -116, 109, 0, -116, 117, 0, -100, 125, 0, -100, -122, 0, -91, -114, 24, -91, -110, 82, -75, -94, 66, -58, -70, 115, -58, -70, 115, -50, -70, 82, -42, -53, -100, -34, -61, 66, -34, -57, 90, -34, -49, -124, -34, -41, -75, -34, -37, -75, -34, -37, -58, -25, -61, 24, -25, -45, -116, -25, -45, -116, -9, -33, 90, -9, -29, -124, -1, -33, 74, -1, -33, 90, -1, -33, 90, -1, -33, 99, -1, -33, 99, -1, -29, 99, -1, -29, 107, -1, -29, 115, -1, -25, 123, -1, -25, -124, -1, -1, -1, 8, 8, 16, 8, 12, 16, 8, 16, 24, 16, 16, 16, 16, 20, 16, 16, 20, 24, 24, 24, 24, 24, 28, 24, 24, 28, 33, 33, 32, 16, 33, 32, 33, 33, 36, 33, 33, 36, 41, 33, 36, 49, 41, 40, 41, 41, 40, 49, 41, 44, 33, 41, 44, 41, 41, 44, 49, 41, 48, 57, 49, 44, 16, 49, 48, 49, 49, 48, 57, 49, 52, 49, 49, 52, 57, 57, 52, 16, 57, 56, 57, 57, 60, 24, 57, 60, 66, 66, 65, 57, 66, 69, 66, 74, 65, 16, 74, 73, 41, 82, 81, 66, 90, 77, 16, 107, 93, 33, 107, 101, 49, 123, 105, 16, 123, 121, 90, -124, 113, 33, -124, 125, 66, -108, 121, 0, -100, -126, 0, -100, -126, 16, -100, -122, 0, -100, -122, 8, -100, -122, 24, -100, -122, 41, -100, -118, 41, -100, -118, 57, -100, -118, 66, -100, -114, 57, -100, -114, 66, -100, -110, 82, -100, -110, 99, -91, -122, 0, -91, -118, 0, -91, -114, 41, -91, -114, 49, -91, -102, 123, -91, -90, -91, -91, -90, -83, -83, -106, 41, -83, -106, 49, -83, -102, 57, -83, -102, 74, -83, -102, 90, -83, -98, 99, -83, -90, -116, -75, -102, 24, -75, -98, 57, -75, -90, 107, -75, -86, -124, -75, -82, 123, -75, -78, -91, -67, -102, 0, -67, -94, 24, -67, -94, 41, -67, -90, 74, -67, -82, 99, -67, -74, -108, -67, -70, -91, -67, -70, -83, -67, -66, -67, -58, -90, 0, -58, -90, 8, -58, -90, 41, -58, -74, 107, -50, -90, 0, -50, -86, 16, -50, -82, 0, -42, -70, 33, -42, -70, 82, -42, -53, -116, -42, -45, -50, -34, -74, 16, -25, -66, 0, -25, -61, 41, -25, -45, -116, -25, -41, -91, -17, -61, 0, -17, -57, 0, -17, -57, 8, -17, -57, 16, -17, -53, 8, -17, -53, 16, -17, -53, 24, -17, -53, 33, -17, -53, 49, -17, -49, 49, -17, -49, 66, -17, -49, 82, -17, -45, 99, -17, -37, 123, -17, -21, -42, -17, -21, -17, -9, -53, 0, -9, -49, 0, -9, -49, 24, -9, -45, 33, -9, -45, 66, -9, -41, 57, -9, -41, 66, -9, -37, 74, -9, -37, 90, -9, -33, 99, -9, -33, 107, -9, -33, 115, -9, -29, -124, -9, -29, -108, -9, -25, -116, -9, -25, -108, -9, -21, -50, -9, -9, -9, -1, -45, 16, -1, -41, 33, -1, -37, 66, -1, -33, 99, -1, -29, 90, -1, -25, 107, -1, -25, 115, -1, -21, -124, -1, -21, -116, -1, -21, -83, -1, -17, -100, -1, -17, -83, -1, -13, -83, -1, -13, -75, -1, -13, -67, -1, -13, -58, -1, -13, -50, -1, -9, -58, -1, -9, -50, -1, -9, -42, -1, -5, -50, -1, -5, -34, -1, -5, -25, -1, -1, -17, -1, -1, -9, -1, -1, -1, -52, -66, -83, 44, 0, 0, 0, 36, 116, 82, 78, 83, 68, 34, 68, 119, -103, -18, -18, -18, 68, -103, -120, -86, -52, 51, -35, -18, -18, 68, 85, 51, -35, -35, -18, 119, -103, 102, 34, 51, 34, 119, 51, -103, 119, 119, 119, 0, -100, 50, -20, -18, 0, 0, 2, -27, 73, 68, 65, 84, 120, -38, -123, -44, 91, 79, 19, 65, 20, 0, -32, 51, 123, -23, 118, -69, 109, -95, 77, 33, 109, -71, -76, -48, 68, -79, -120, 34, 10, 68, 8, 24, 99, -60, 22, -86, 47, 40, 15, 38, -8, 111, -4, 19, 38, 38, 38, 62, 24, 17, 76, 76, -19, 2, 1, -125, 32, 106, 98, -44, -60, 7, -75, 16, 19, 110, 114, 83, 35, -19, 118, 11, 101, 119, 118, -58, -83, -126, 64, -71, -19, 121, -103, 76, -66, -20, -50, -98, 51, -25, 112, 33, 40, 120, -24, -70, -123, 47, -40, -30, 10, 77, -74, -9, 87, 2, -8, -93, 81, -74, -121, 41, -23, 10, -34, -77, 30, -123, 72, -113, 24, -69, 95, 61, -93, 33, -31, 112, 100, -36, 98, 98, 16, -11, -105, -48, 4, 17, 15, 67, -58, 77, -90, -117, -128, -105, -44, 2, 36, 64, 60, 24, -103, 38, 74, 40, -94, -120, -100, -94, -42, 1, 70, 56, 8, 25, 49, 20, -59, -56, 96, -13, 113, 18, 54, 100, 106, -35, -113, -116, -21, 66, -57, 102, -2, -20, -7, 64, -43, 110, 120, -58, -14, -123, 8, -57, -24, -107, -36, -50, 107, 25, 103, 13, -108, 63, -28, -9, 34, 28, 97, -82, -91, 118, -99, 111, -102, -81, 10, -66, -20, -35, 82, 91, 8, -73, 120, -102, 119, 27, -57, 84, 106, 49, -36, -106, 72, 23, -15, 59, 72, -117, 56, 27, -119, 29, 50, 59, 5, -84, 122, 59, 13, 87, 91, 33, 94, 44, 108, 35, -11, -122, -93, -11, -5, 36, 41, 42, 59, -77, 100, 87, -51, 0, -25, -62, 39, -56, -50, 25, -10, 22, 50, -24, 20, -2, 33, -75, 27, -22, 70, 63, 47, 81, 94, 74, 118, 80, 98, 6, 29, -4, -122, -120, 112, 66, -55, 56, 90, -55, -80, -87, 76, -92, 118, 9, -63, -55, 21, 16, 49, -46, -110, -106, -13, -96, -40, -45, -93, -53, -84, -76, -31, -86, 84, 64, -127, 122, 50, -30, 20, 56, 88, -65, -99, 11, 127, 41, 95, -125, 101, -114, 18, 99, 94, -21, 78, -83, -68, 90, -109, 116, -59, -43, 32, -87, -26, 87, 74, 79, -29, -79, 18, 14, -12, -39, -74, -116, -97, 61, -73, 52, 67, 24, 42, -111, -43, 7, -96, 101, 5, 3, 19, -74, -2, 123, 62, -11, -87, 50, 45, -36, -57, -63, -102, 52, 87, 65, -79, -24, 1, 10, 2, -81, -21, 41, -122, 101, 115, -104, 0, -99, 53, 19, 3, -104, 89, -99, -17, 47, -25, 32, -8, -88, 11, -4, -108, 34, -33, 2, -43, 56, 30, 56, -125, 2, 53, 116, 42, 20, -3, -28, 48, -121, 114, 31, 100, 61, 127, -16, -96, -36, 41, -70, -88, -44, 4, -102, 37, 77, 88, 3, 99, -115, 18, -20, 110, 74, 113, -64, 33, -3, -85, -84, -123, -2, -90, 32, 32, 67, 56, -104, -110, 46, 103, -91, -119, -76, 89, 53, 6, -76, 92, -96, -47, 66, 49, 79, 105, -14, 9, 14, 109, 37, -45, 84, -32, -30, 80, 32, -115, -80, 78, -40, 77, -30, -79, -73, 122, 20, -99, 3, -100, -20, -61, 85, -1, -53, 18, -112, -23, -39, 98, -94, -86, -65, 117, -115, -41, -96, -94, 93, -92, 10, 8, 20, -110, -113, -11, -48, -82, 2, 7, 70, 33, 20, -50, 50, 53, -68, 0, -81, 93, 81, -69, 10, -84, -7, -77, 31, -5, -40, -54, 61, 87, -59, 63, 10, 80, -25, -88, 44, 82, 0, -49, -66, -87, 117, 33, -112, 50, 99, -125, 66, 105, -63, -91, -13, -65, 96, 80, 61, -84, 115, -48, -7, -2, -35, -108, 124, -41, -95, 76, 48, -37, 102, -41, -11, -11, -115, 68, -48, -91, 12, 3, 27, -51, -106, -87, 59, 72, 29, 79, -40, 74, 15, 104, 4, -33, 80, 68, -68, 72, -51, -59, -123, 6, 118, 45, 30, -73, 23, 31, -40, 82, -66, 97, 100, 105, -50, 47, 88, 125, -36, 102, 43, 62, -92, 57, -67, 67, 12, -76, -3, -16, 16, -14, 60, 23, 119, 31, -38, -26, 94, 25, 65, -5, 42, -116, 25, 123, 76, -31, -64, -16, 38, 24, 117, 17, 108, 79, -35, 71, -114, 30, 111, -68, 91, 113, 15, -72, -113, 25, 98, -34, 126, 106, 117, 31, 55, -23, -64, -73, 111, 7, -2, 0, 124, -94, 51, -104, -86, -99, -30, 63, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126]
	putstatic _appIcons // com_plazmic_games_roosterRIMResources
	arrayinit [0, 33, 99, 111, 109, 46, 112, 108, 97, 122, 109, 105, 99, 46, 114, 111, 111, 115, 116, 101, 114, 46, 82, 111, 111, 115, 116, 101, 114, 77, 73, 68, 108, 101, 116]
	putstatic _appArgs // com_plazmic_games_roosterRIMResources
	arrayinit [0]
	putstatic _appFlags // com_plazmic_games_roosterRIMResources
	arrayinit [0, 3, 49, 46, 48]
	putstatic _manifestVersion // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_133:"Manifest-Version"
	getstatic _manifestVersion // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, 1, 48]
	putstatic _midletJarSize // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_134:"MIDlet-Jar-Size"
	getstatic _midletJarSize // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, 68, 82, 111, 111, 115, 116, 101, 114, 44, 105, 109, 103, 47, 114, 111, 111, 115, 116, 101, 114, 73, 99, 111, 110, 95, 49, 54, 48, 56, 48, 53, 46, 112, 110, 103, 44, 99, 111, 109, 46, 112, 108, 97, 122, 109, 105, 99, 46, 114, 111, 111, 115, 116, 101, 114, 46, 82, 111, 111, 115, 116, 101, 114, 77, 73, 68, 108, 101, 116]
	astore_0 
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_135:"MIDlet-1"
	aload_0 
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, 11, 82, 111, 111, 115, 116, 101, 114, 46, 106, 97, 114]
	putstatic _url // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_136:"MIDlet-Jar-URL"
	getstatic _url // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, 8, 67, 76, 68, 67, 45, 49, 46, 49]
	putstatic _midletConfiguration // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_137:"MicroEdition-Configuration"
	getstatic _midletConfiguration // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, 8, 49, 46, 48, 46, 48, 46, 54, 52]
	putstatic _version // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_138:"MIDlet-Version"
	getstatic _version // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, 7, 82, 111, 111, 115, 116, 101, 114]
	putstatic _midletName // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_139:"MIDlet-Name"
	getstatic _midletName // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, -61, 84, 104, 101, 32, 100, 101, 102, 97, 117, 108, 116, 32, 99, 111, 110, 116, 114, 111, 108, 115, 32, 116, 111, 32, 112, 108, 97, 121, 32, 116, 104, 101, 32, 103, 97, 109, 101, 32, 97, 114, 101, 32, 119, 61, 117, 112, 44, 32, 115, 61, 100, 111, 119, 110, 44, 32, 107, 61, 108, 101, 102, 116, 44, 32, 108, 61, 114, 105, 103, 104, 116, 46, 32, 32, 84, 104, 101, 32, 103, 97, 109, 101, 32, 97, 108, 115, 111, 32, 102, 101, 97, 116, 117, 114, 101, 115, 32, 116, 104, 117, 109, 98, 119, 104, 101, 101, 108, 32, 115, 117, 112, 112, 111, 114, 116, 32, 98, 117, 116, 32, 116, 104, 101, 32, 107, 101, 121, 112, 97, 100, 32, 105, 115, 32, 114, 101, 99, 111, 109, 109, 101, 110, 100, 101, 100, 46, 32, 32, 67, 111, 110, 116, 114, 111, 108, 115, 32, 99, 97, 110, 32, 98, 101, 32, 99, 117, 115, 116, 111, 109, 105, 122, 101, 100, 32, 111, 110, 32, 116, 104, 101, 32, 67, 111, 110, 116, 114, 111, 108, 32, 112, 97, 103, 101, 46]
	putstatic _description // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_140:"MIDlet-Description"
	getstatic _description // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, 12, 80, 108, 97, 122, 109, 105, 99, 32, 73, 110, 99, 46]
	putstatic _vendor // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_141:"MIDlet-Vendor"
	getstatic _vendor // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, 8, 77, 73, 68, 80, 45, 50, 46, 48]
	putstatic _midletProfile // com_plazmic_games_roosterRIMResources
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_142:"MicroEdition-Profile"
	getstatic _midletProfile // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [0, 1, 48]
	astore_0 
	getstatic _properties // com_plazmic_games_roosterRIMResources
	ldc literal_143:"RIM-MIDlet-Flags-1"
	aload_0 
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	arrayinit [77, 97, 110, 105, 102, 101, 115, 116, 45, 86, 101, 114, 115, 105, 111, 110, 58, 32, 49, 46, 48, 13, 10, 77, 73, 68, 108, 101, 116, 45, 74, 97, 114, 45, 83, 105, 122, 101, 58, 32, 48, 13, 10, 77, 73, 68, 108, 101, 116, 45, 49, 58, 32, 82, 111, 111, 115, 116, 101, 114, 44, 105, 109, 103, 47, 114, 111, 111, 115, 116, 101, 114, 73, 99, 111, 110, 95, 49, 54, 48, 56, 48, 53, 46, 112, 110, 103, 44, 99, 111, 109, 46, 112, 108, 97, 122, 109, 105, 99, 46, 114, 111, 111, 115, 116, 101, 114, 46, 82, 111, 111, 115, 116, 101, 114, 77, 73, 68, 108, 101, 116, 13, 10, 77, 73, 68, 108, 101, 116, 45, 74, 97, 114, 45, 85, 82, 76, 58, 32, 82, 111, 111, 115, 116, 101, 114, 46, 106, 97, 114, 13, 10, 77, 105, 99, 114, 111, 69, 100, 105, 116, 105, 111, 110, 45, 67, 111, 110, 102, 105, 103, 117, 114, 97, 116, 105, 111, 110, 58, 32, 67, 76, 68, 67, 45, 49, 46, 49, 13, 10, 77, 73, 68, 108, 101, 116, 45, 86, 101, 114, 115, 105, 111, 110, 58, 32, 49, 46, 48, 46, 48, 46, 54, 52, 13, 10, 77, 73, 68, 108, 101, 116, 45, 78, 97, 109, 101, 58, 32, 82, 111, 111, 115, 116, 101, 114, 13, 10, 77, 73, 68, 108, 101, 116, 45, 68, 101, 115, 99, 114, 105, 112, 116, 105, 111, 110, 58, 32, 84, 104, 101, 32, 100, 101, 102, 97, 117, 108, 116, 32, 99, 111, 110, 116, 114, 111, 108, 115, 32, 116, 111, 32, 112, 108, 97, 121, 32, 116, 104, 101, 32, 103, 97, 109, 101, 32, 97, 114, 101, 32, 119, 61, 117, 112, 44, 32, 115, 61, 100, 111, 119, 110, 44, 32, 107, 61, 108, 101, 102, 116, 44, 32, 108, 61, 114, 105, 103, 104, 116, 46, 32, 32, 84, 104, 101, 32, 103, 97, 109, 101, 32, 97, 108, 115, 111, 32, 102, 101, 97, 116, 117, 114, 101, 115, 32, 116, 104, 117, 109, 98, 119, 104, 101, 101, 108, 32, 115, 117, 112, 112, 111, 114, 116, 32, 98, 117, 116, 32, 116, 104, 101, 32, 107, 101, 121, 112, 97, 100, 32, 105, 115, 32, 114, 101, 99, 111, 109, 109, 101, 110, 100, 101, 100, 46, 32, 32, 67, 111, 110, 116, 114, 111, 108, 115, 32, 99, 97, 110, 32, 98, 101, 32, 99, 117, 115, 116, 111, 109, 105, 122, 101, 100, 32, 111, 110, 32, 116, 104, 101, 32, 67, 111, 110, 116, 114, 111, 108, 32, 112, 97, 103, 101, 46, 13, 10, 77, 73, 68, 108, 101, 116, 45, 86, 101, 110, 100, 111, 114, 58, 32, 80, 108, 97, 122, 109, 105, 99, 32, 73, 110, 99, 46, 13, 10, 77, 105, 99, 114, 111, 69, 100, 105, 116, 105, 111, 110, 45, 80, 114, 111, 102, 105, 108, 101, 58, 32, 77, 73, 68, 80, 45, 50, 46, 48, 13, 10, 82, 73, 77, 45, 77, 73, 68, 108, 101, 116, 45, 70, 108, 97, 103, 115, 45, 49, 58, 32, 48, 13, 10]
	putstatic _manifest // com_plazmic_games_roosterRIMResources
	getstatic _resources // com_plazmic_games_roosterRIMResources
	ldc literal_144:"META-INF/MANIFEST.MF"
	getstatic _manifest // com_plazmic_games_roosterRIMResources
	invokevirtual put( java.util.Hashtable, java.lang.Object, java.lang.Object ) // pc=3
	pop 
	getstatic _resources // com_plazmic_games_roosterRIMResources
	invokestatic populate( java.util.Hashtable ) // com_plazmic_games_roosterRIMResourcesPopulator0
	getstatic _resources // com_plazmic_games_roosterRIMResources
	invokestatic_lib module:com_plazmic_games_rooster-1.class#0.routine_9(  ) // class#0
	getstatic _resources // com_plazmic_games_roosterRIMResources
	invokestatic_lib module:com_plazmic_games_rooster-2.class#0.routine_14(  ) // class#0
	getstatic _resources // com_plazmic_games_roosterRIMResources
	invokestatic_lib module:com_plazmic_games_rooster-3.class#0.routine_14(  ) // class#0
	getstatic _resources // com_plazmic_games_roosterRIMResources
	invokestatic_lib module:com_plazmic_games_rooster-4.class#0.routine_9(  ) // class#0
	clinit_return 
	}

	// @@@@@@@@@@@@@ Virtual routines 

public final java.lang.Object instantiateMIDlet( com.rim.resources.com_plazmic_games_roosterRIMResources, java.lang.String ); // address: 0
	{
	enter_narrow 
	aload_1 
	ldc literal_132:"com.plazmic.rooster.RoosterMIDlet"
	invokevirtual_short .equals // idx=1 pc=2
	ifeq Label9
	new RoosterMIDlet
	dup 
	invokespecial com.plazmic.rooster.RoosterMIDlet.<init> // pc=1
	areturn 
Label9:
	new_lib IllegalArgumentException//java.lang.IllegalArgumentException java.lang.IllegalArgumentException java.lang.IllegalArgumentException
	dup 
	invokespecial_lib java.lang.IllegalArgumentException.<init> // pc=1
	athrow 
	}

}
