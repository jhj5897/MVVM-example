package com.example.mvvmtest

import android.app.Application
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.example.mvvmtest.databinding.UserDialogBinding
import java.util.*

class UserDialog(mContext: Context) : Dialog(mContext) {
    private lateinit var binding:UserDialogBinding

    private val viewModel:MainViewModel = MainViewModel(mContext.applicationContext as Application)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.user_dialog, null, false)
        setContentView(binding.root)

        Objects.requireNonNull(window)?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // 버튼 리스너 설정
        binding.btnSave.setOnClickListener {
            viewModel.insert(UserEntity(binding.editTextName.text.toString(),
                binding.editTextGender.text.toString(),binding.editTextBirth.text.toString()))
            dismiss()
        }
        binding.btnCancel.setOnClickListener {
            dismiss()
        }

    }

}
