package com.example.vitalygolovin.jobgram.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vitalygolovin.jobgram.R;
import com.example.vitalygolovin.jobgram.model.classes.VacancyListItem;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Employer;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.LogoUrls;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Salary;
import com.example.vitalygolovin.jobgram.view.fragments.VacancyListFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class VacancyAdapter extends RecyclerView.Adapter<VacancyAdapter.VacancyViewHolder> {

    private Context mContext;
    private List<VacancyListItem> mVacancyList;
    private VacancyListFragment mFragment;

    public VacancyAdapter(Context context,List<VacancyListItem> vacancies,VacancyListFragment fragment){
        mContext = context;
        mVacancyList = vacancies;
        mFragment = fragment;
    }

    @Override
    public VacancyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.vacancy_item_view,parent,false);
        return new VacancyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VacancyViewHolder holder, int position) {
        VacancyListItem vacancy = mVacancyList.get(position);
        holder.bindVacancy(vacancy,position);
    }

    @Override
    public int getItemCount() {
        return mVacancyList.size();
    }

    public void setVacancyList(List<VacancyListItem> vacancyList) {
        mVacancyList = vacancyList;
    }

    class VacancyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.item_vacancy_name)
        TextView mVacancyName;
        @BindView(R.id.item_vacancy_company)
        TextView mCompanyName;
        @BindView(R.id.item_vacancy_salary)
        TextView mSalary;
        @BindView(R.id.item_vacancy_logo)
        ImageView mLogo;

        private int mPosition;

        public VacancyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        private void bindVacancy(VacancyListItem vacancy, int position){

            if(vacancy != null) {
                mPosition = position;
                mVacancyName.setText(vacancy.getName());
                Employer company = vacancy.getEmployer();
                mCompanyName.setText(company.getName());
                Salary salary = vacancy.getSalary();
                if(salary != null) {
                    if (salary.getFrom() != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(mContext.getString(R.string.ot));
                        stringBuilder.append(" ");
                        stringBuilder.append(salary.getFrom());
                        stringBuilder.append(" ");
                        stringBuilder.append(mContext.getString(R.string.rub));
                        mSalary.setText(stringBuilder.toString());
                    }
                }

                LogoUrls logo = company.getLogoUrls();
                if (logo != null) {
                    String logoUrl = logo.getOriginal();
                    if (logoUrl != null) {
                        Picasso.with(mContext).load(logoUrl).into(mLogo);
                    }
                }

            }
        }


        @Override
        public void onClick(View v) {
            mFragment.onListItemClick(mPosition);
        }
    }
}