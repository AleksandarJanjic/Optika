package com.optika.interfaces;

import com.optika.model.Contact;

public interface ContactInterface {

    void Save(Contact contact);

    Contact findById(int Id);
}
