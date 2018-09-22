# SaveHashMapToPreferences
This is used to save hasmaps to preferences for quick reference


##Setup

no setup... once the library is loaded just reference the commands by accessing them directly.  All calls are static.

	SaveHashMapToPreferences.getHashmap(hasmapId, context). //returns Hashmap<String, ArrayList<String>>
	SaveHashMapToPreferences.saveHashmap(hashMap, hasMapName, context). //hasMap needs to be Hashmap<String, ArrayList<String>>
	SaveHashMapToPreferences.addItemToHashMap(hashMapName, itemId, ArrayList<String> items, context)
	SaveHashMapToPreferences.removeItemFromHashMap(hashMapName, item, context)
	
	SaveHashMapToPreferences.getPlainStringStringHashmap(hashMapId, context) //returns HashMap<String, String>
	SaveHashMapToPreferences.savePlainStringStringHashmap(hashMap, hashMapName, Context context). //takes HashMap<String, String>
	SaveHashMapToPreferences.removeItemFromPlainStringStringHashMap(hashMapId, item, Context context)
	SaveHashMapToPreferences.addItemToPlainStringStringHashMap(hashMapName, itemId, item, Context context)
        





	