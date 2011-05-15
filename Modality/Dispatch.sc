Dispatch{

	//	classvar <all;

	//	var <key;
	var <name;

	var <funcChain;

	var <envir;

	*new{ |name|
		^super.new.init(name);
	}

	init{ |nm|
		name = nm; // name is used to register with different controls in their functiondict
		envir = ();
		funcChain = FuncChain.new;
	}

	value{ |value, ctlkey, ktl, parent| 
		// kontrol or dispatch that sends it, key of the ctl/dispatch output, value 
		funcChain.valueAll( value, ctlkey, this, ktl );
		//	dispChain.valueAll( this.name, key, value, envir );
	}

	addFunction{ |key,func,addAction=\addToTail,target|
		// by default adds the action to the end of the list
		// if target is set to a function, addActions \addBefore, \addAfter, \addReplace, are valid
		// otherwise there is \addToTail or \addToHead
	}
	
}