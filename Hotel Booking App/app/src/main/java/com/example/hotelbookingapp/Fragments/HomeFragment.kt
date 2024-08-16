package com.example.hotelbookingapp.Fragments

import android.app.DatePickerDialog
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelbookingapp.Adapters.HotelItemAdapter
import com.example.hotelbookingapp.DataClass.HotelModelClass
import com.example.hotelbookingapp.R
import com.example.hotelbookingapp.ViewModels.HomeFragmentViewModel
import com.example.hotelbookingapp.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.Calendar

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeFragmentViewModel

    lateinit var adapterObj: HotelItemAdapter
    lateinit var dataList: ArrayList<HotelModelClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        viewModel = ViewModelProvider(requireActivity())[HomeFragmentViewModel::class.java]

        counterValueOfGuestAndRooms()

        setHotelInRecyclerView()

//        ADD filter bottom sheet
        binding.filterAdd.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())

            val view = layoutInflater.inflate(R.layout.activity_filter,null)

            val cancelBtn = view.findViewById<TextView>(R.id.cancel_filter)
            val applyBtn = view.findViewById<Button>(R.id.apply_btn)

            cancelBtn.setOnClickListener {
                dialog.dismiss()
            }

            applyBtn.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setCancelable(false)

            dialog.setContentView(view)

            dialog.show()

        }

        binding.guestInc.setOnClickListener {
            viewModel.incrementCountGuestsValue()
        }

        binding.guestDec.setOnClickListener {
            viewModel.decrementCountGuestsValue()
        }

        binding.roomsInc.setOnClickListener {
            viewModel.incrementCountRoomsValue()
        }

        binding.roomsDec.setOnClickListener {
            viewModel.decrementCountRoomsValue()
        }

        binding.checkInDate.setOnClickListener {
            datePicker(binding.checkInDate)
        }

        binding.checkOutDate.setOnClickListener {
            datePicker(binding.checkOutDate)
        }

        binding.hotelFindBtn.setOnClickListener {
            binding.frameLayout1.isVisible = false
            binding.frameLayout2.isVisible = true
        }

        binding.backBtn.setOnClickListener {
            binding.frameLayout1.isVisible = true
            binding.frameLayout2.isVisible = false
        }

        // Inflate the layout for this fragment
        return (binding.root)
    }

    private fun setHotelInRecyclerView() {
        dataList = ArrayList()

        dataList.add(HotelModelClass(R.drawable.hot, "AYANA Resort", "$200 - $500"))
        dataList.add(HotelModelClass(R.drawable.hotel, "AYANA Resort", "$300 - $500"))
        dataList.add(HotelModelClass(R.drawable.hot, "AYANA Resort", "$200 - $500"))
        dataList.add(HotelModelClass(R.drawable.hotel, "AYANA Resort", "$300 - $500"))

        adapterObj = HotelItemAdapter(dataList,requireContext())
        binding.hotelRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.hotelBusinessRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.hotelRecyclerView.adapter = adapterObj
        binding.hotelBusinessRecyclerView.adapter = adapterObj
    }

    private fun counterValueOfGuestAndRooms() {
        viewModel.counterGuestsLiveData.observe(requireActivity(), Observer {
            binding.guestCount.setText(it.toString())
        })

        viewModel.counterRoomsLiveData.observe(requireActivity(), Observer {
            binding.roomsCount.setText(it.toString())
        })
    }


    fun datePicker(dateText:TextView){
        val calender = Calendar.getInstance()

        val day = calender.get(Calendar.DAY_OF_MONTH)
        val month = calender.get(Calendar.MONTH)
        val year = calender.get(Calendar.YEAR)

        val datePickerDialog = DatePickerDialog(
            requireContext(), {
                    view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                dateText.setText(dat)
            }, year , month, day
        )

        datePickerDialog.show()
    }

}