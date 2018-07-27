package com.korlimann.korlisfoodcraft.util.recipes;


// This interface specifies a Method that contains one or more additional conditions to craft/smelt/process resources that will be automatically checked in AdvancedProcessingInputSet's
// This interface is designed to be implemented with an Anonymous Class
public interface IMetaCondition {
	
	public boolean isFullfilled();

}
